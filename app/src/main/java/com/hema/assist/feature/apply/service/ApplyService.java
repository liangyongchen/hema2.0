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

    /**
     *  分期申请准备数据
     * @param id  用户ID
     * @param token
     * @return
     */
    @POST(NetworkConfig.PROJECT_NAME + "/api/loanUser/userInfoStep")
    Observable<BaseResult<StageApplyInfo>> userInfoStep(
            @Query("id") Integer id,
            @Query("token") String token);

}
