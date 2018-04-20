package com.hema.assist.feature.apply.presenter;

import android.app.Activity;

import com.hema.assist.common.action.Action2;
import com.hema.assist.common.base.BasePresenterImpl;
import com.hema.assist.common.base.BaseResult;
import com.hema.assist.entity.LoginInfo;
import com.hema.assist.feature.apply.adapter.CardCertificationAdapter;
import com.hema.assist.feature.apply.contract.StageApplyContract;
import com.hema.assist.feature.home.contract.HomeContract;
import com.wtw.p2p.R;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Project: WangTouWang
 * Author: frank
 * Created: 2018/2/6:下午4:06
 * Email: 656266591@qq.com
 * Desc:
 */
public class StageApplyPresenterImpl extends BasePresenterImpl<StageApplyContract.View> implements StageApplyContract.Presenter {

    private StageApplyContract.Model homeModel;

    @Inject
    public StageApplyPresenterImpl(StageApplyContract.Model homeModel) {
        this.homeModel = homeModel;
    }


    @Override
    public void getBannerData() {
        List<String> list = new ArrayList<>();
        list.add("http://img0.imgtn.bdimg.com/it/u=1352823040,1166166164&fm=27&gp=0.jpg");
        list.add("http://img3.imgtn.bdimg.com/it/u=2293177440,3125900197&fm=27&gp=0.jpg");
        list.add("http://img3.imgtn.bdimg.com/it/u=3967183915,4078698000&fm=27&gp=0.jpg");
        list.add("http://img0.imgtn.bdimg.com/it/u=3184221534,2238244948&fm=27&gp=0.jpg");
        list.add("http://img4.imgtn.bdimg.com/it/u=1794621527,1964098559&fm=27&gp=0.jpg");
        list.add("http://img4.imgtn.bdimg.com/it/u=1243617734,335916716&fm=27&gp=0.jpg");
        mUi.setBanner(list);
    }

    @Override
    public void getCardData() {
        List<CardCertificationAdapter.ItemModel> list = new ArrayList<>();
        list.add(new CardCertificationAdapter.ItemModel("身份认证", R.drawable.fenqi_one_s2, "请出示身份证正反面", "去认证"));
        list.add(new CardCertificationAdapter.ItemModel("银行卡认证", R.drawable.fenqi_two_s2, "请出示身份证正反面", "去认证"));
        list.add(new CardCertificationAdapter.ItemModel("个人信息", R.drawable.fenqi_three_s2, "请出示身份证正反面", "去认证"));
        list.add(new CardCertificationAdapter.ItemModel("手机认证", R.drawable.fenqi_four_s2, "请出示身份证正反面", "去认证"));
        mUi.setCard(list);
    }

    @Override
    public void getStageAplly() {

    }

}
