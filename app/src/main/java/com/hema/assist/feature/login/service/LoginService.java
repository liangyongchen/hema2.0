package com.hema.assist.feature.login.service;


import com.hema.assist.common.base.BaseResult;
import com.hema.assist.common.network.NetworkConfig;
import com.hema.assist.entity.LoginInfo;
import com.hema.assist.entity.TempModel;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Project: WangTouWang
 * Author: frank
 * Created: 2018/2/7:下午2:58
 * Email: 656266591@qq.com
 * Desc:
 */
public interface LoginService {

    /**
     * 获取临时token
     *
     * @return
     */
    @GET(NetworkConfig.PROJECT_NAME + "/api/auth/account/getTempToken")
    Observable<BaseResult<TempModel>> getTempToken();

    /**
     * 登录
     *
     * @param loginName 用户名
     * @param password  密码
     * @param code      验证码
     * @param tempToken 临时token
     * @param isSa      是否是sa
     * @return
     */
    @POST(NetworkConfig.PROJECT_NAME + "/api/auth/account/login")
    Observable<BaseResult<LoginInfo>> login(
            @Query("loginName") String loginName
            , @Query("password") String password
            , @Query("code") String code
            , @Query("tempToken") String tempToken
            , @Query("isSa") Boolean isSa);
}
