package com.hema.assist.feature.home.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import com.hema.assist.common.base.BaseActivity;
import com.hema.assist.common.views.Lock9View;
import com.wtw.p2p.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 手势密码
 * Created by 河马安卓 on 2018/4/23.
 */
public class HandPwdActivity extends BaseActivity {

    @BindView(R.id.lock_9_view)
    Lock9View lock9View;


    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_hand_pwd;
    }

    @Override
    protected void onCreateFinished() {
        lock9View.setGestureCallback(new Lock9View.GestureCallback() {

            @Override
            public void onNodeConnected(@NonNull int[] numbers) {
                toast("+ " + numbers[numbers.length - 1]);
            }

            @Override
            public void onGestureFinished(@NonNull int[] numbers) {
                StringBuilder builder = new StringBuilder();
                for (int number : numbers) {
                    builder.append(number);
                }
                toast("= " + builder.toString());

            }

        });
    }
}
