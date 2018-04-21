package com.hema.assist.feature.home.service;

import com.hema.assist.common.base.BaseResult;
import com.hema.assist.common.network.NetworkConfig;
import com.hema.assist.entity.ChangePwdInfo;

import io.reactivex.Observable;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by 河马安卓 on 2018/4/20.
 */

public interface HomeService {

    @POST(NetworkConfig.PROJECT_NAME + "/api/auth/account/modifyPwd")
    Observable<BaseResult<ChangePwdInfo>> modifyPwd(
            @Query("token") String token
            , @Query("newPwd") String newPwd
            , @Query("oldPwd") String oldPwd
            , @Query("isSa") Boolean isSa);

}
