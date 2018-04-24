package com.hema.assist.feature.apply.contract;

import com.hema.assist.common.action.Action3;
import com.hema.assist.common.base.BasePresenter;
import com.hema.assist.common.base.BaseResult;
import com.hema.assist.entity.StageApplyInfo;
import com.hema.assist.feature.apply.adapter.CardCertificationAdapter;

import java.util.List;

/**
 * Project: WangTouWang
 * Author: frank
 * Created: 2018/2/6:下午4:06
 * Email: 656266591@qq.com
 * Desc:
 */
public interface StageApplyContract {

    interface Model {


        // 返回认证界面的列表信息
        void userInfoStep(int id,String token, Action3<Boolean, String, BaseResult<StageApplyInfo>> callBack);


    }

    interface View {

        // 设置头部banner信息
        void setBanner(List<String> data);

        // 设置认证的进度
        void setIvSpeedSrc(int id);

        // 返回认证界面列表信息
        void userInfoStepSuccess(String msg,List<CardCertificationAdapter.ItemModel> data);

        // 认证数据获取失败
        void userInfoStepFailed(String msg);

    }

    interface Presenter extends BasePresenter<View> {

        // 获取banner信息
        void getBannerData();

        // 获取认证界面列表信息
        void userInfoStep(int id,String token);


    }


}

