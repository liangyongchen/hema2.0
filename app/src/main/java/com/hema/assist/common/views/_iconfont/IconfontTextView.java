package com.hema.assist.common.views._iconfont;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

import com.hema.assist.app.App;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by asus on 2017/7/24.
 */

public class IconfontTextView extends TextView {

    public IconfontTextView(Context context) {
        super(context);
        init();
    }

    public IconfontTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public IconfontTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        // 设置字体图标
        this.setTypeface(App.getContext().getIconTypeFace());
        paintText = new Paint();
        paintText.setColor(Color.WHITE);
        paintText.setStyle(Paint.Style.FILL);
        paintText.setAntiAlias(true);

        paintCircle = new Paint();
        paintCircle.setColor(Color.RED);
        paintCircle.setStyle(Paint.Style.FILL);
        paintCircle.setAntiAlias(true);
    }

    private Paint paintText; // 字体颜色

    private Paint paintCircle; // 园颜色

    private String mText;

    public void setText(String text) {
        mText = text;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (StringUtils.isEmpty(mText)) {
            return;
        }


    }
}
