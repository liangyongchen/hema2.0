package com.hema.assist.common.base;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import com.hema.assist.common.action.Action1;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Project: WangTouWang
 * Author: frank
 * Created: 2018/2/6:上午10:34
 * Email: 656266591@qq.com
 * Desc:
 */
public abstract class BaseActivity extends AppCompatActivity {

    private Toast mToast;
    protected BaseActivity mContext;
    protected Unbinder unbinder;

    /**
     * getContentViewLayoutID() 方法返回的View
     */
    protected View contentView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;

        //获取extras
        Bundle extras = getIntent().getExtras();
        if (null != extras) {
            getBundleExtras(extras);
        }

        //获取布局id，设置内容视图
        int layoutId = getContentViewLayoutID();
        if (layoutId <= 0) {
            throw new IllegalArgumentException("You must return a right contentView layout resource Id");
        }
        contentView = getLayoutInflater().inflate(layoutId, null);
        setContentView(contentView);

        unbinder = ButterKnife.bind(this);

        onCreateFinished();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    /********************** toast方法 ***************************/
    public void toast(String text) {
        if (mToast == null) {
            mToast = Toast.makeText(this, text, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(text);
        }
        mToast.setGravity(Gravity.CENTER, 0, 0);
        mToast.show();

    }


    /********************** 抽象方法 ***************************/

    /**
     * get bundle data 该方法会优先于 event 执行 ，该方法调用后才会调用 isEventBindHere() 方法
     *
     * @param extras bundle bundle已判断，不为空
     */
    protected void getBundleExtras(Bundle extras){};

    /**
     * bind layout resource file
     *
     * @return id of layout resource
     */
    protected abstract int getContentViewLayoutID();

    /**
     * onCreate执行完成
     */
    protected abstract void onCreateFinished();


    /********************** 权限请求 ***************************/
    private Action1<Boolean> mRequestPermissionAction;

    /**
     * 请求需要用户确定的权限
     */
    public void requestPermission(String permission, Action1<Boolean> action) {
        if (Build.VERSION.SDK_INT >= 23) {
            int checkCallPhonePermission = ContextCompat.checkSelfPermission(mContext, permission);
            if (checkCallPhonePermission != PackageManager.PERMISSION_GRANTED) {
                mRequestPermissionAction = action;
                ActivityCompat.requestPermissions(mContext, new String[]{permission}, 0);
                return;
            } else {
                //上面已经写好的拨号方法
                action.call(true);
            }
        } else {
            //上面已经写好的拨号方法
            action.call(true);
        }
    }

    /**
     * 请求需要用户确定的权限
     */
    public void requestPermission(String[] permissions, Action1<Boolean> action) {
        if (Build.VERSION.SDK_INT >= 23) {
            int checkCallPhonePermission = 0;
            for (String permission : permissions) {
                checkCallPhonePermission = ContextCompat.checkSelfPermission(mContext, permission);
                if (checkCallPhonePermission != PackageManager.PERMISSION_GRANTED) {
                    //还没有获取权限
                    break;
                }
            }
            if (checkCallPhonePermission != PackageManager.PERMISSION_GRANTED) {
                mRequestPermissionAction = action;
                ActivityCompat.requestPermissions(mContext, permissions, 0);
                return;
            } else {
                //上面已经写好的拨号方法
                action.call(true);
            }
        } else {
            //上面已经写好的拨号方法
            action.call(true);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 0) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission Granted
                mRequestPermissionAction.call(true);
            } else {
                // Permission Denied
                mRequestPermissionAction.call(false);
            }
        }
    }


    // region 设置 Edittext 之外点击随意地方，隐藏键盘

    /**
     * 设置 Edittext 之外点击随意地方，隐藏键盘
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {

        if (ev.getAction() == MotionEvent.ACTION_DOWN) {

            View v = getCurrentFocus();
            if (isShouHideInput(v, ev)) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                if (imm != null)
                    imm.hideSoftInputFromWindow(v.getApplicationWindowToken(), 0);
            }
            return super.dispatchTouchEvent(ev);
        }

        if (getWindow().superDispatchTouchEvent(ev)) {
            return true;
        }
        return onTouchEvent(ev);
    }

    // 计算 Edittext 之外的位置
    private boolean isShouHideInput(View v, MotionEvent event) {

        if (v != null && (v instanceof EditText)) {
            int[] leftTop = {0, 0};
            // 获取输入框当前的 location位置
            v.getLocationInWindow(leftTop);
            int left = leftTop[0];
            int top = leftTop[1];
            int bottom = top + v.getHeight();
            int right = left + v.getWidth();

            v.clearFocus(); // 失去焦点

            // 点击的是输入框的区域，保存点击EditText事件
            if (event.getX() > left && event.getX() < right && event.getY() > top && event.getY() < bottom) {
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

    // endregion


}
