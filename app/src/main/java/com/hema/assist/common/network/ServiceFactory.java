package com.hema.assist.common.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hema.assist.common.network.interceptor.BaseParameterInterceptor;
import com.hema.assist.common.network.interceptor.ErrorHandlerInterceptor;
import com.hema.assist.common.utils.AndroidUtils;
import com.hema.assist.common.network.interceptor.CustomHttpLoggingInterceptor;

import java.security.cert.CertificateException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Project: WangTouWang
 * Author: frank
 * Created: 2018/2/7:下午2:28
 * Email: 656266591@qq.com
 * Desc:  服务工厂
 */
public class ServiceFactory {

    private static Lock mLock;//单例锁
    private static ServiceFactory mInstance;//单例

    private final Gson mGson;

    static {
        mLock = new ReentrantLock();
    }

    private ServiceFactory() {
        mGson = new GsonBuilder().create();
    }

    /**
     * 获取服务工厂实例
     *
     * @return
     */
    public static ServiceFactory getInstance() {
        if (mInstance == null) {
            mLock.lock();
            if (mInstance == null) {
                mInstance = new ServiceFactory();
            }
            mLock.unlock();
        }

        return mInstance;
    }

    /**
     * 创建服务
     *
     * @param serviceClass
     * @param <S>
     * @return
     */
    public <S> S createService(Class<S> serviceClass) {
        return createService(NetworkConfig.getServerHost(), serviceClass);
    }

    /**
     * 创建服务
     *
     * @param baseUrl
     * @param serviceClass
     * @param <S>
     * @return
     */
    public <S> S createService(String baseUrl, Class<S> serviceClass) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(getOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create(mGson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit.create(serviceClass);
    }

    public OkHttpClient getOkHttpClient() {
        //定制OkHttp
//        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        OkHttpClient.Builder httpClientBuilder = ServiceFactory.unsafeOkHttpClient().newBuilder();
        //设置超时时间
        httpClientBuilder.connectTimeout(NetworkConfig.DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        httpClientBuilder.writeTimeout(NetworkConfig.DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        httpClientBuilder.readTimeout(NetworkConfig.DEFAULT_TIMEOUT, TimeUnit.SECONDS);

        //添加默认参数
        httpClientBuilder.addInterceptor(new BaseParameterInterceptor());

        //打印log
        if(AndroidUtils.isDebug()){
            httpClientBuilder.addInterceptor(new CustomHttpLoggingInterceptor());
//            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
//            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
//            httpClientBuilder.addInterceptor(logging);
        }

        //错误拦截
        httpClientBuilder.addInterceptor(new ErrorHandlerInterceptor());



        //设置缓存
//        File httpCacheDirectory = new File(FileUtils.getCacheDir(SolidApplication.getInstance()), "OkHttpCache");
//        httpClientBuilder.cache(new Cache(httpCacheDirectory, 10 * 1024 * 1024));
        //处理拦截器，主要是做了个header和连接超时、读取超时设置，我项目里header放了些签名信息，主要是这里能拿到整个请求的所有参数，做任何想做的事，而且是全局动态处理
        //if (httpClientBuilder.interceptors() != null) {
        //    httpClientBuilder.interceptors().clear();
        //}
        //httpClientBuilder.addNetworkInterceptor(new Interceptor() {
        //    @Override
        //    public Response intercept(Chain chain) throws IOException {
        //        return null;
        //    }
        //});

//        CustomHttpLoggingInterceptor logging = new CustomHttpLoggingInterceptor();
//        logging.setLevel(CustomHttpLoggingInterceptor.Level.BODY);
//        httpClientBuilder.addInterceptor(logging);
        return httpClientBuilder.build();
    }



    private static OkHttpClient unsafeOkHttpClient() {
        try {
            // Create a trust manager that does not validate certificate chains
            final TrustManager[] trustAllCerts = new TrustManager[]{
                    new X509TrustManager() {
                        @Override
                        public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                        }

                        @Override
                        public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                        }

                        @Override
                        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                            return new java.security.cert.X509Certificate[]{};
                        }
                    }
            };

            // Install the all-trusting trust manager
            final SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
            // Create an ssl socket factory with our all-trusting manager
            final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.sslSocketFactory(sslSocketFactory);
            builder.hostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });
            return builder.build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
