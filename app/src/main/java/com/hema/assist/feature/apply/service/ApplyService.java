package com.hema.assist.feature.apply.service;


import com.hema.assist.common.base.BaseResult;
import com.hema.assist.common.network.NetworkConfig;
import com.hema.assist.entity.StageApplyInfo;

import io.reactivex.Observable;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Project: WangTouWang
 * Author: frank
 * Created: 2018/2/7:下午2:58
 * Email: 656266591@qq.com
 * Desc:
 */
public interface ApplyService {

    // 认证模块服务
    @POST(NetworkConfig.PROJECT_NAME + "/api/loanOrder/userInfoStep")
    Observable<BaseResult<StageApplyInfo>> userInfoStep(
            @Query("token") String token);

}
