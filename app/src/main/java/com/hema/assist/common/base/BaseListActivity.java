package com.hema.assist.common.base;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

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


    public static class ViewHolder {
        @BindView(R.id.toolbar_back)
        public ImageView toolbarBack;
        @BindView(R.id.toolbar_title)
        public TextView toolbarTitle;
        @BindView(R.id.toolbar_news)
        public ImageView toolbarNews;
        @BindView(R.id.toolbar)
        public Toolbar toolbar;
        @BindView(R.id.recycler_view)
        public RecyclerView recyclerView;
        @BindView(R.id.refresh_layout)
        public SmartRefreshLayout refreshLayout;
        @BindView(R.id.list_content)
        public RelativeLayout listContent;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
