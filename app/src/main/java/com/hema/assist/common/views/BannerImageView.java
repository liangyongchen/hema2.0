package com.hema.assist.common.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.hema.assist.common.views._iconfont.IconfontTextView;
import com.wtw.p2p.R;

/**
 * Created by 河马安卓 on 2018/4/19.
 */

public class BannerImageView extends FrameLayout {


    public BannerImageView(Context context) {
        super(context);
    }

    public BannerImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BannerImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
        getWidth();
        getHeight();
    }

    /**
     * 获取 内 linerLayout 的布局
     */
    private LinearLayout linearLayout;
    int linerWidth = ViewGroup.LayoutParams.MATCH_PARENT;
    int linerHeight = ViewGroup.LayoutParams.MATCH_PARENT;

    /**
     * 认证块
     */
    private IconfontTextView titleText;

    /**
     * 内部图片
     */
    private ImageView imageView;
    int imgWidth = ViewGroup.LayoutParams.WRAP_CONTENT;
    int imgHeight = ViewGroup.LayoutParams.WRAP_CONTENT;

    /**
     * 提示块
     */
    private IconfontTextView msgText;

    /**
     * 认证按钮
     */
    private Button mButton;


    private void init(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {

        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.BannerImageView);
        linerWidth = ta.getInteger(R.styleable.BannerImageView_layoutW, linerWidth);
        linerHeight = ta.getInteger(R.styleable.BannerImageView_layoutH, linerHeight);
        imgWidth = ta.getInteger(R.styleable.BannerImageView_imgW, imgWidth);
        imgHeight = ta.getInteger(R.styleable.BannerImageView_imgH, imgHeight);
        ta.recycle();

        linearLayout = new LinearLayout(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(linerWidth, linerHeight);
        linearLayout.setHorizontalGravity(ViewGroup.SCROLL_AXIS_VERTICAL); // vertical

        addView(linearLayout);

        // 添加标头
        titleText = new IconfontTextView(context);
        LinearLayout.LayoutParams titleParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.CENTER);
        titleParams.setMargins(0, 30, 0, 30);
        titleText.setTextColor(context.getResources().getColor(R.color.black0));
        titleText.setTextSize(15.0f);
        titleText.setLayoutParams(titleParams);
        linearLayout.addView(titleText);

        // 添加 图片
        imageView = new ImageView(context);
        LinearLayout.LayoutParams imgParams = new LinearLayout.LayoutParams(
                imgWidth, imgHeight, Gravity.CENTER);
        linearLayout.addView(imageView);

        // 添加说明
        msgText = new IconfontTextView(context);
        LinearLayout.LayoutParams msgParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.CENTER);
        msgParams.setMargins(0, 10, 0, 40);
        msgText.setTextColor(context.getResources().getColor(R.color.black1));
        msgText.setTextSize(10.0f);
        msgText.setLayoutParams(msgParams);
        linearLayout.addView(msgText);

        mButton = new Button(context);
        LinearLayout.LayoutParams btnParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.CENTER);
        btnParams.setMargins(50, 40, 50, 0);
        mButton.setTextColor(context.getResources().getColor(R.color.white));
        mButton.setBackgroundColor(context.getResources().getColor(R.color.colorPrimary));
        linearLayout.addView(mButton);
        mButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mButtonClick.onButtonClick(v);
            }
        });

    }


    public interface ButtonClick {
        void onButtonClick(View v);
    }

    private ButtonClick mButtonClick;

    public void setOnButtonClick(ButtonClick buttonClick) {
        this.mButtonClick = buttonClick;
    }


    // 设置标题文字
    public void setTitleText(String text) {
        titleText.setText(text);
    }

    // 设置名片模块
    public void setImageView(Drawable drawable) {
        imageView.setImageDrawable(drawable);
    }

    // 设置提示内容
    public void setMsgText(String msg) {
        msgText.setText(msg);
    }

    // 设置按钮文字
    public void setButtonText(String text) {
        mButton.setText(text);
    }

    // 获取内部图片
    public ImageView getNImageView() {
        return imageView;
    }

}
