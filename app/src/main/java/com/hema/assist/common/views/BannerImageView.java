package com.hema.assist.common.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.wtw.p2p.R;

/**
 * Created by 河马安卓 on 2018/4/19.
 */

public class BannerImageView extends ImageView {


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

    // 获取 内 linerLayout 的布局
    private LinearLayout linearLayout;
    int linerWidth = ViewGroup.LayoutParams.MATCH_PARENT;
    int linerHeight = ViewGroup.LayoutParams.MATCH_PARENT;
    // 获取图片
    private Drawable mDrable;

    // 内部图片
    private ImageView imageView;
    int imgWidth = ViewGroup.LayoutParams.WRAP_CONTENT;
    int imgHeight = ViewGroup.LayoutParams.WRAP_CONTENT;

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


        // 添加View
        imageView = new ImageView(context);
        LinearLayout.LayoutParams imgParams = new LinearLayout.LayoutParams(imgWidth, imgHeight);
        imgParams.gravity = Gravity.CENTER;
        linearLayout.addView(imageView);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

    }
}
