package com.hema.assist.common.network.interceptor;

import com.hema.assist.app.App;
import com.hema.assist.common.base.BaseResult;
import com.hema.assist.common.loger.AppLogger;
import com.hema.assist.common.network.ResultCode;
import com.hema.assist.common.utils.DisplayUtil;
import com.hema.assist.common.utils.GsonUtil;
import com.hema.assist.common.utils.ToastUtil;
import com.hema.assist.feature.login.view.LoginActivity;

import java.io.EOFException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;

import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http.HttpHeaders;
import okio.Buffer;
import okio.BufferedSource;

/**
 * Project: WangTouWang
 * Author: frank
 * Created: 2018/2/8:上午10:23
 * Email: 656266591@qq.com
 * Desc: 异常处理拦截器
 */
public class ErrorHandlerInterceptor implements Interceptor {

    private static final Charset UTF8 = Charset.forName("UTF-8");

    @Override
    public Response intercept(Chain chain) throws IOException {

        Request request = chain.request();
        Response response = chain.proceed(request);

        ResponseBody responseBody = response.body();
        long contentLength = responseBody.contentLength();

        if (!HttpHeaders.hasBody(response)) {
            //END HTTP
        } else if (bodyEncoded(response.headers())) {
            //HTTP (encoded body omitted)
        } else {
            BufferedSource source = responseBody.source();
            source.request(Long.MAX_VALUE); // Buffer the entire body.
            Buffer buffer = source.buffer();

            Charset charset = UTF8;
            MediaType contentType = responseBody.contentType();
            if (contentType != null) {
                try {
                    charset = contentType.charset(UTF8);
                } catch (UnsupportedCharsetException e) {
                    //Couldn't decode the response body; charset is likely malformed.
                    return response;
                }
            }

            if (!isPlaintext(buffer)) {
                AppLogger.i("<-- END HTTP (binary " + buffer.size() + "-byte body omitted)");
                return response;
            }

            if (contentLength != 0) {
                String result = buffer.clone().readString(charset);
                //获取到response的body的string字符串
                //do something .... <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
                BaseResult baseResult = GsonUtil.jsonToObj(result, BaseResult.class);//对于javabean直接给出class实例
                if (!baseResult.getCode().equals(ResultCode.RESULT_CODE_SUCCESS_00)) {
                    if (baseResult.getCode().equals(ResultCode.RESULT_CODE_AUTH_FAIL_01)) {
                        ToastUtil.showDebugToast("登录");
                        DisplayUtil.readyGo(App.context, LoginActivity.class);
                    }
                }

                AppLogger.d(baseResult);

            }

            AppLogger.i("<-- END HTTP (" + buffer.size() + "-byte body)");
        }

        return response;
    }


    static boolean isPlaintext(Buffer buffer) throws EOFException {
        try {
            Buffer prefix = new Buffer();
            long byteCount = buffer.size() < 64 ? buffer.size() : 64;
            buffer.copyTo(prefix, 0, byteCount);
            for (int i = 0; i < 16; i++) {
                if (prefix.exhausted()) {
                    break;
                }
                int codePoint = prefix.readUtf8CodePoint();
                if (Character.isISOControl(codePoint) && !Character.isWhitespace(codePoint)) {
                    return false;
                }
            }
            return true;
        } catch (EOFException e) {
            return false; // Truncated UTF-8 sequence.
        }
    }

    private boolean bodyEncoded(Headers headers) {
        String contentEncoding = headers.get("Content-Encoding");
        return contentEncoding != null && !contentEncoding.equalsIgnoreCase("identity");
    }
}
