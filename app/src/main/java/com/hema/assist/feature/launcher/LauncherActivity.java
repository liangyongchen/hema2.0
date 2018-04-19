package com.hema.assist.feature.launcher;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.hema.assist.common.action.Action1;
import com.hema.assist.common.base.BaseActivity;
import com.hema.assist.common.utils.PermissionUtil;
import com.hema.assist.feature.login.view.LoginActivity;
import com.wtw.p2p.R;

public class LauncherActivity extends BaseActivity {


    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_launcher;
    }

    @Override
    protected void onCreateFinished() {

        requestPermission(PermissionUtil.HEMA_ANDROID_PERMISSION, new Action1<Boolean>() {
            @Override
            public void call(Boolean aBoolean) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (aBoolean) {
                            //在主线程执行
                            startMainActivity();
                        }
                    }
                }, 2000);
            }
        });


    }

    private void startMainActivity() {

        Intent intent = new Intent(this, LoginActivity.class);

        startActivity(intent);

        finish();

    }
}
