package com.hema.assist.feature.home.adapter;

import android.support.annotation.Nullable;
import android.view.View;

import com.chad.library.adapter.base.BaseViewHolder;
import com.hema.assist.common.adapter.BaseSingleAdapter;

import java.util.List;

/**
 * Created by 河马安卓 on 2018/4/24.
 */

public class OverdueAdapter extends BaseSingleAdapter<String,OverdueAdapter.childView> {


    public OverdueAdapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }


    @Override
    protected void convert(childView helper, String item) {

    }

    class childView extends BaseViewHolder{

        public childView(View view) {
            super(view);
        }
    }
}
