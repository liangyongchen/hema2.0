package com.hema.assist.feature.apply.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wtw.p2p.R;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 河马安卓 on 2018/4/23.
 */

public class UserAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final int SELECT = 0;
    public static final int INPUT = 1;
    public static final int SWICTH = 2;


    private Context mContext;
    private List<ItemInfo> mData;
    LayoutInflater mInflater;

    public UserAdapter(Context context, List<ItemInfo> data) {
        this.mContext = context;
        this.mData = data;
        this.mInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == SELECT) {
            return new SelectViewHolder(mInflater.inflate(R.layout.user_item_select, parent, false));
        } else if (viewType == INPUT) {
            return new SelectViewHolder(mInflater.inflate(R.layout.user_item_input, parent, false));

        } else if (viewType == SWICTH) {
            return new SelectViewHolder(mInflater.inflate(R.layout.user_item_switch, parent, false));

        }

        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    // 根据不同的类型设置不同的布局
    @Override
    public int getItemViewType(int position) {

        if (mData.get(position).type == SELECT) {
            return SELECT;
        } else if (mData.get(position).type == INPUT) {
            return INPUT;
        } else if (mData.get(position).type == SWICTH) {
            return SWICTH;
        }

        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        if (mData != null && mData.size() > 0) {
            return mData.size();
        }
        return 0;
    }

    // 选择layout
    class SelectViewHolder extends RecyclerView.ViewHolder {

        public SelectViewHolder(View itemView) {
            super(itemView);
        }

    }

    // 输入layout
    class InputViewHolder extends RecyclerView.ViewHolder {

        public InputViewHolder(View itemView) {
            super(itemView);
        }

    }

    // Switch layout
    class SwitchViewHolder extends RecyclerView.ViewHolder {

        public SwitchViewHolder(View itemView) {
            super(itemView);
        }

    }


    class ItemInfo implements Serializable {

        /**
         * key
         */
        private boolean isSigon;
        private String key;

        /**
         * value
         */
        private int type; // 什么类型的布局就有什么类型的数据 0:select ; 1:input ; 2:swicth
        // 选择layout
        private String selectValue;
        // 输入框layout
        private String inputValue;
        // Swicth 布局
        private boolean swValue;
        private String swText;

    }


}
