package com.hema.assist.feature.home.adapter;

import android.support.annotation.Nullable;
import android.view.View;

import com.chad.library.adapter.base.BaseViewHolder;
import com.hema.assist.common.adapter.BaseSingleAdapter;
import com.hema.assist.entity.OverdueInfo;

import java.util.List;

/**
 * Created by 河马安卓 on 2018/4/24.
 */

public class OverdueAdapter extends BaseSingleAdapter<OverdueInfo, OverdueAdapter.childView> {


    private List<OverdueInfo> mData;

    public OverdueAdapter(int layoutResId, @Nullable List<OverdueInfo> data) {
        super(layoutResId, data);
        this.mData = data;
    }

    @Override
    protected void convert(childView helper, OverdueInfo item) {

    }

    public void setData(List<OverdueInfo> data) {
        mData.remove(mData);
        mData.addAll(data);
        notifyDataSetChanged();
    }

    class childView extends BaseViewHolder {

        public childView(View view) {
            super(view);
        }
    }
}
