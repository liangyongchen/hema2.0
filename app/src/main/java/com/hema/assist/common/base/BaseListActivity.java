package com.hema.assist.common.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.wtw.p2p.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Project: WangTouWang
 * Author: frank
 * Created: 2018/2/8:下午3:25
 * Email: 656266591@qq.com
 * Desc:
 */
public class BaseListActivity extends BaseActivity {

    protected ViewHolder viewHolder;

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.layout_base_list;
    }

    @Override
    protected void onCreateFinished() {
            viewHolder = new ViewHolder(contentView);
    }

    static class ViewHolder {
        @BindView(R.id.recycler_view)
        RecyclerView recyclerView;
        @BindView(R.id.refresh_layout)
        SmartRefreshLayout refreshLayout;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
