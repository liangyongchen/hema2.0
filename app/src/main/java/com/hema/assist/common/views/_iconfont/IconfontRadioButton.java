package com.hema.assist.common.views._iconfont;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RadioButton;

import com.hema.assist.app.App;


/**
 * Created by asus on 2017/7/24.
 */

public class IconfontRadioButton extends RadioButton {

    public IconfontRadioButton(Context context) {
        super(context);
        init();
    }

    public IconfontRadioButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public IconfontRadioButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
//        设置字体图标
        this.setTypeface(App.getContext().getIconTypeFace());
    }

}
