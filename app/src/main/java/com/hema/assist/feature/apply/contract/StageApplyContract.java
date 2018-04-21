package com.hema.assist.feature.apply.contract;

import com.hema.assist.common.action.Action2;
import com.hema.assist.common.action.Action3;
import com.hema.assist.common.base.BasePresenter;
import com.hema.assist.common.base.BaseResult;
import com.hema.assist.entity.LoginInfo;
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

        void setBanner(List<String> data);

        void setCard(List<CardCertificationAdapter.ItemModel> data);

        void setIvSpeedSrc(int id);

        void setStageAplly();

        // 返回认证界面列表信息
        void userInfoStepSuccess(String msg,BaseResult<StageApplyInfo> callBack);

        void userInfoStepFailed(String msg);

    }

    interface Presenter extends BasePresenter<View> {

        void getBannerData();

        void getStageAplly();

        // 刚进入界面，获取数据
        void userInfoStep(int id,String token);


    }


}

