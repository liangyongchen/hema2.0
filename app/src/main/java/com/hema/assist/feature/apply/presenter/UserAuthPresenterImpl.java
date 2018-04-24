package com.hema.assist.feature.apply.presenter;


import android.app.Activity;

import com.hema.assist.common.base.BasePresenterImpl;
import com.hema.assist.feature.apply.adapter.UserAdapter.ItemInfo;
import com.hema.assist.feature.apply.contract.UserAuthContract;

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
public class UserAuthPresenterImpl extends BasePresenterImpl<UserAuthContract.View> implements UserAuthContract.Presenter {

    private UserAuthContract.Model model;

    @Inject
    public UserAuthPresenterImpl(UserAuthContract.Model model) {
        this.model = model;
    }


    @Override
    public void getJobData(Activity ac) {

        List<ItemInfo> data = new ArrayList<>();
        data.add(new ItemInfo("单位全称", true, "请输入单位全称", 0));
        data.add(new ItemInfo("所在部门", true, "请输入所在部门", 0));
        data.add(new ItemInfo("职位", false, "请选择"));
        data.add(new ItemInfo("行业类型", true, "请选择"));
        data.add(new ItemInfo("单位性质", false, "请选择"));
        data.add(new ItemInfo("总工作经验", true, "请选择"));
        data.add(new ItemInfo("现单位入职时间", true, "请选择"));
        data.add(new ItemInfo("单位所在地区", true, "请选择"));
        data.add(new ItemInfo("单位详细地址", true, "请输入工作单位详细地址", 0));
        data.add(new ItemInfo("月收入总额", true, "请输入月收入金额", 0));
        data.add(new ItemInfo("社保账号", false, "请输入社保账号", 0));
        data.add(new ItemInfo("办公/个体电话", true, "请输入办公电话", 0));
        data.add(new ItemInfo("学历", true, "请选择"));
        mUi.setRecyclerViewData(data);

    }

    @Override
    public void getFamilyData(Activity ac) {

        List<ItemInfo> data = new ArrayList<>();
        data.add(new ItemInfo("婚姻状况", true, "单身"));
        data.add(new ItemInfo("住房状况", true, "请选择"));
        data.add(new ItemInfo("月支出", false, "请选择"));
        data.add(new ItemInfo("家庭成员姓名", true, "请输入成员姓名", 0));
        data.add(new ItemInfo("家庭成员关系", true, "请选择"));
        data.add(new ItemInfo("与户籍地址相同", true, true, null));
        data.add(new ItemInfo("家庭成员联系地址", true, "请输入居住详细地址", 0));
        mUi.setRecyclerViewData(data);

    }

    @Override
    public void getContactData(Activity ac) {

        List<ItemInfo> data = new ArrayList<>();
        data.add(new ItemInfo("电子邮箱", true, "请输入电子邮箱", 0));
        data.add(new ItemInfo("微信号", false, "请输入微信号", 0));
        data.add(new ItemInfo("支付宝账号", false, "请输入支付宝账号", 0));
        data.add(new ItemInfo("QQ号码", false, "请输入QQ号码", 0));
        data.add(new ItemInfo("户籍所在地区", true, "请选择"));
        data.add(new ItemInfo("户籍详细地址", true, "请输入用户籍详细地址", 0));
        data.add(new ItemInfo("居住地同户籍地址", true, true, null));
        data.add(new ItemInfo("居住所在地区", true, "请选择"));
        data.add(new ItemInfo("居住详细地址", true, "请输入居住详细地址", 0));
        mUi.setRecyclerViewData(data);

    }

}
