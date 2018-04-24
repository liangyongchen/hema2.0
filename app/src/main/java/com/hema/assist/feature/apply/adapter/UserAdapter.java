package com.hema.assist.feature.apply.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.Toast;

import com.hema.assist.common.views.SignTextView;
import com.wtw.p2p.R;

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 河马安卓 on 2018/4/23.
 */

public class UserAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final int INPUT = 0;
    public static final int SELECT = 1;
    public static final int SWICTH = 2;
    public static final int COMMIT = 3;


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

        if (viewType == INPUT) {
            return new InputViewHolder(mInflater.inflate(R.layout.user_item_input, parent, false));
        } else if (viewType == SELECT) {
            return new SelectViewHolder(mInflater.inflate(R.layout.user_item_select, parent, false));
        } else if (viewType == SWICTH) {
            return new SwitchViewHolder(mInflater.inflate(R.layout.user_item_switch, parent, false));
        } else if (viewType == COMMIT) {
            return new CommitViewHolder(mInflater.inflate(R.layout.user_item_commit, parent, false));
        }

        return null;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        if (holder instanceof SelectViewHolder) {
            SelectViewHolder h = (SelectViewHolder) holder;
            h.setData(mData.get(position), position);
        } else if (holder instanceof InputViewHolder) {
            InputViewHolder h = (InputViewHolder) holder;
            h.setData(mData.get(position), position);
        } else if (holder instanceof SwitchViewHolder) {
            SwitchViewHolder h = (SwitchViewHolder) holder;
            h.setData(mData.get(position), position);
        } else if (holder instanceof CommitViewHolder) {
            CommitViewHolder h = (CommitViewHolder) holder;
            h.setData(mData, position);
        }

    }


    // 根据不同的类型设置不同的布局
    @Override
    public int getItemViewType(int position) {

        if ((position + 1) == getItemCount()) {
            return COMMIT;
        } else {
            if (mData.get(position).type == SELECT) {
                return SELECT;
            } else if (mData.get(position).type == INPUT) {
                return INPUT;
            } else if (mData.get(position).type == SWICTH) {
                return SWICTH;
            }
        }

        return super.getItemViewType(position);
    }


    @Override
    public int getItemCount() {
        if (mData != null && mData.size() > 0) {
            return mData.size() + 1;
        }
        return 0;
    }


    // 设置数据
    public void setData(List<UserAdapter.ItemInfo> data) {
        this.mData = data;
        notifyDataSetChanged();
    }


    /**
     * 选择layout
     */
    class SelectViewHolder extends RecyclerView.ViewHolder {


        @BindView(R.id.stv_key)
        SignTextView mKey;
        @BindView(R.id.btn_value)
        LinearLayout mValue;

        public SelectViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setData(ItemInfo model, int position) {

            mKey.setSignText(String.format("%s", model.key), model.isSigon);
            mValue.setOnClickListener(v -> {
                Toast.makeText(mContext, String.format("点击了 %s 想，该项需要 %s", position, model.isSigon ? "必填" : "随便"), Toast.LENGTH_SHORT).show();
            });
        }
    }


    /**
     * 输入layout
     */
    class InputViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.stv_key)
        SignTextView mKey;
        @BindView(R.id.et_value)
        EditText mValue;

        public InputViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setData(ItemInfo model, int position) {

            mKey.setSignText(String.format("%s", model.key), model.isSigon);
            mValue.setOnKeyListener((v, keyCode, event) -> {
                if (keyCode == event.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN) {
                    model.inputValue = StringUtils.isBlank(mValue.getText().toString()) ? "" : mValue.getText().toString();
                }
                return false;
            });

        }
    }


    /**
     * Switch layout
     */
    class SwitchViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.stv_key)
        SignTextView mKey;
        @BindView(R.id.sw_value)
        Switch mValue;

        public SwitchViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setData(ItemInfo model, int position) {

            mKey.setSignText(String.format("%s", model.key), model.isSigon);
            mValue.setChecked(model.isSwicth);

        }

    }


    /**
     * 提交布局
     */
    class CommitViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.btn_next)
        Button mKey;

        public CommitViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setData(final List<ItemInfo> data, int position) {

            mKey.setOnClickListener(v -> {
                if (mOnCommit != null) {
                    mOnCommit.onCommitData(v, data);
                }
                Toast.makeText(mContext, "点击了" + position + "项", Toast.LENGTH_SHORT).show();
            });

        }
    }

    // model 类
    public static class ItemInfo implements Serializable {

        /**
         * key
         */
        private boolean isSigon;
        private String key;

        /**
         * value
         */
        public int type; // 什么类型的布局就有什么类型的数据 0:input ; 1:select ;  2:swicth
        // 选择layout
        public String selectValue;
        // 输入框layout
        public String inputValue; // 进行数据保存
        public String hintValue; // 进行数据保存
        // Swicth 布局
        public boolean isSwicth;
        public String swValue;

        // 输入布局有参
        public ItemInfo(String key, boolean isSigon) {
            this.key = key;
            this.isSigon = isSigon;
            this.type = 0;
        }

        // 输入布局有参
        public ItemInfo(String key, boolean isSigon, String hintValue, int type) {
            this.key = key;
            this.isSigon = isSigon;
            this.hintValue = hintValue;
            this.type = type;
        }


        // 选择布局有参
        public ItemInfo(String key, boolean isSigon, String selectValue) {
            this.key = key;
            this.isSigon = isSigon;
            this.selectValue = selectValue;
            this.type = 1;
        }

        // sw布局有参
        public ItemInfo(String key, boolean isSigon, boolean isSwicth, String swValue) {
            this.key = key;
            this.isSigon = isSigon;
            this.isSwicth = isSwicth;
            this.swValue = swValue;
            this.type = 2;
        }

    }


    // 接口回掉数据给主界面
    public interface OnCommit {
        void onCommitData(View v, List<ItemInfo> data);
    }

    private OnCommit mOnCommit;

    public void setOnCommitData(OnCommit onCommit) {
        this.mOnCommit = onCommit;
    }


}
