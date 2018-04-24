package com.hema.assist.common.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.text.Html;
import android.util.AttributeSet;
import android.widget.TextView;

import com.wtw.p2p.R;

/**
 * Created by 河马安卓 on 2018/4/23.
 */

public class SignTextView extends TextView {

    private boolean sign = false; // 默认是不标记的文字

    public SignTextView(Context context) {
        super(context);
        init(context, null, 0);
    }

    public SignTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public SignTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {

        if (attrs == null) {
            return;
        }

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.SignText);
        sign = a.getBoolean(R.styleable.SignText_sign, false);
        a.recycle();

    }

    public void setSignText(String text) {
        if (sign) {
            String s = text + "<font color='#ff4850'>*</font>";
            setText(Html.fromHtml(s));
        } else {
            setText(text);
        }
    }

    public void setSignText(String text, boolean isSign) {
        this.sign = isSign;
        setSignText(text);
    }

    // 设置是否标识
    public void setSign(boolean sign) {
        this.sign = sign;
    }


}
