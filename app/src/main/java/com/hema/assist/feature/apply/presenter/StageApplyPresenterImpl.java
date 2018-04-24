package com.hema.assist.feature.apply.presenter;


import com.hema.assist.common.base.BasePresenterImpl;
import com.hema.assist.entity.StageApplyInfo;
import com.hema.assist.feature.apply.adapter.CardCertificationAdapter;
import com.hema.assist.feature.apply.contract.StageApplyContract;
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

    private StageApplyContract.Model applyModel;

    @Inject
    public StageApplyPresenterImpl(StageApplyContract.Model applyModel) {
        this.applyModel = applyModel;
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
    public void userInfoStep(int id, String token) {

        applyModel.userInfoStep(id, token, (aBoolean, s, result) -> {
            if (aBoolean) {
                mUi.userInfoStepSuccess(s, getCardData(result.getData()));
            } else {
                mUi.userInfoStepFailed(s);
            }
        });

    }


    private List<CardCertificationAdapter.ItemModel> getCardData(StageApplyInfo data) {

        List<CardCertificationAdapter.ItemModel> list = new ArrayList<>();
        if (data == null) {
            return list; // 防止返回null适配器报错
        }

        if (data.getWCYZ() == 1) {
            list.add(new CardCertificationAdapter.ItemModel(R.string.SFRZ, R.drawable.fenqi_one_s2, "请出示身份证正反面", "已完成", true));
            list.add(new CardCertificationAdapter.ItemModel(R.string.YHK, R.drawable.fenqi_two_s2, "请出示身份证正反面", "已完成", true));
            list.add(new CardCertificationAdapter.ItemModel(R.string.GRXX, R.drawable.fenqi_three_s2, "请出示身份证正反面", "已完成", true));
            list.add(new CardCertificationAdapter.ItemModel(R.string.SJRZ, R.drawable.fenqi_four_s2, "请出示身份证正反面", "已完成", true));
            mUi.setIvSpeedSrc(R.drawable.fenqi_lc4_s2);
            return list;
        }

        // 身份认证
        if (data.getSFRZ() == 1) {
            list.add(new CardCertificationAdapter.ItemModel(R.string.SFRZ, R.drawable.fenqi_one_s2, "请出示身份证正反面", "已完成", true));
            mUi.setIvSpeedSrc(R.drawable.fenqi_lc1_s2);
        } else {
            list.add(new CardCertificationAdapter.ItemModel(R.string.SFRZ, R.drawable.fenqi_one_s2, "请出示身份证正反面", "去认证", false));
            mUi.setIvSpeedSrc(R.drawable.fenqi_lc1_s2);
        }

        // 银行卡
        if (data.getYHK() == 1) {
            list.add(new CardCertificationAdapter.ItemModel(R.string.YHK, R.drawable.fenqi_two_s2, "请出示身份证正反面", "已完成", true));
            mUi.setIvSpeedSrc(R.drawable.fenqi_lc2_s2);
        } else {
            list.add(new CardCertificationAdapter.ItemModel(R.string.YHK, R.drawable.fenqi_two_s2, "请出示身份证正反面", "去认证", false));
            mUi.setIvSpeedSrc(R.drawable.fenqi_lc1_s2);
        }

        // 个人信息
        if (data.getGRXX() == 1) {
            list.add(new CardCertificationAdapter.ItemModel(R.string.GRXX, R.drawable.fenqi_three_s2, "请出示身份证正反面", "已完成", true));
            mUi.setIvSpeedSrc(R.drawable.fenqi_lc3_s2);
        } else {
            list.add(new CardCertificationAdapter.ItemModel(R.string.GRXX, R.drawable.fenqi_three_s2, "请出示身份证正反面", "去认证", false));
            mUi.setIvSpeedSrc(R.drawable.fenqi_lc2_s2);

        }

        // 手机认证
        if (data.getSJRZ() == 1) {
            list.add(new CardCertificationAdapter.ItemModel(R.string.SJRZ, R.drawable.fenqi_four_s2, "请出示身份证正反面", "已完成", true));
            mUi.setIvSpeedSrc(R.drawable.fenqi_lc4_s2);
        } else {
            list.add(new CardCertificationAdapter.ItemModel(R.string.SJRZ, R.drawable.fenqi_four_s2, "请出示身份证正反面", "去认证", false));
            mUi.setIvSpeedSrc(R.drawable.fenqi_lc3_s2);
        }

        return list;
    }


}
