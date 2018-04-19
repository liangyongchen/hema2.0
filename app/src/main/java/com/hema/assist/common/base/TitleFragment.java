package com.hema.assist.common.base;

import android.support.annotation.DrawableRes;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hema.assist.common.action.Action0;
import com.wtw.p2p.R;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Project: WangTouWang
 * Author: frank
 * Created: 2018/2/24:上午9:48
 * Email: 656266591@qq.com
 * Desc:
 */
public class TitleFragment extends BaseFragment {

    @BindView(R.id.title)
    TextView mTitle;
    @BindView(R.id.nav_tv_right)
    TextView mAffirmText;
    @BindView(R.id.nav_btn_right)
    ImageView mAffirmImage;
    @BindView(R.id.nav_btn_left)
    ImageView mleftImage;


    private Action0 mRightButtonAction;
    private Action0 mBackButtonAction;
    public boolean showLeftButton = true;

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_title;
    }

    @Override
    protected void onCreateFinished() {

        mAffirmText.setVisibility(View.GONE);
        mAffirmImage.setVisibility(View.GONE);

        String title = getTag();
        if (title != null) {
            String[] titles = title.split("-");
            if (titles.length > 1) {
                //affirm文本
                setAffirmText(titles[1]);
            }

            mTitle.setText(titles[0]);
        }
    }

    @OnClick({
            R.id.nav_btn_left,
            R.id.nav_tv_right,
            R.id.nav_btn_right,
    })
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.nav_btn_left:
                if (mBackButtonAction != null) {
                    mBackButtonAction.call();
                } else {
                    getActivity().onBackPressed();
                }
                break;
            case R.id.nav_tv_right:
            case R.id.nav_btn_right:
                if (mRightButtonAction != null) {
                    mRightButtonAction.call();
                }
                break;
        }
    }

    public void setTitle(String title) {
        mTitle.setText(title);
    }

    public void setLeftImage(@DrawableRes int res) {
        mleftImage.setVisibility(View.VISIBLE);
        mleftImage.setImageResource(res);
    }

    public void setAffirmText(String text) {
        mAffirmText.setVisibility(text.isEmpty() ? View.GONE : View.VISIBLE);
        mAffirmText.setText(text);
    }

    public void setAffirmImage(@DrawableRes int res) {
        mAffirmImage.setVisibility(View.VISIBLE);
        mAffirmImage.setImageResource(res);
    }


    public void setmRightButtonAction(Action0 mRightButtonAction) {
        this.mRightButtonAction = mRightButtonAction;
    }

    public void setBackButtonAction(Action0 backButtonAction) {
        mBackButtonAction = backButtonAction;
    }


    public void setShowLeftButton(boolean showLeftButton) {
        this.showLeftButton = showLeftButton;
        if (showLeftButton){
            mleftImage.setVisibility(View.VISIBLE);
        }else {
            mleftImage.setVisibility(View.INVISIBLE);
        }

    }
}
