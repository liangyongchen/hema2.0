package com.hema.assist.feature.apply.view.idcard;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.hema.assist.common.base.BaseFragment;
import com.hema.assist.common.utils.CommonUtil;
import com.hema.assist.common.utils.FragmentUtil;
import com.wtw.p2p.R;

import butterknife.BindView;

/**
 * Created by 河马安卓 on 2018/4/23.
 */

public class IDCardScan extends BaseFragment {


    @BindView(R.id.iv_FRONT)
    ImageView ivFRONT;
    @BindView(R.id.iv_BACK)
    ImageView ivBACK;
    @BindView(R.id.btn_next)
    Button btnNext;

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_idcard_scan;
    }

    @Override
    protected void onCreateFinished() {
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 跳转确认界面
                FragmentUtil.FragmentStartAddToBackStack(
                        getActivity(),
                        getFragmentManager(),
                        R.id.frameLayout,
                        IDCardScan.this,
                        new IDCardCommit(),
                        CommonUtil.enumActionType.ACTION_FORWARD);
            }
        });
    }


}
