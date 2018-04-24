package com.hema.assist.feature.home.view;


import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hema.assist.common.base.BaseActivity;
import com.hema.assist.component.ComponentFactory;
import com.hema.assist.feature.home.contract.OverdueContract;
import com.wtw.p2p.R;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 逾期管理
 */
public class OverdueActivity extends BaseActivity {

    @Inject
    OverdueContract.Presenter presenter;

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_overdue;
    }

    @Override
    protected void onCreateFinished() {
        ComponentFactory.getActivityComponent().inject(this);
        ViewHolder holder = new ViewHolder(getWindow().getDecorView());
        presenter.attachUi(holder);
    }

    class ViewHolder implements OverdueContract.View {
        @BindView(R.id.toolbar_back)
        ImageView toolbarBack;
        @BindView(R.id.toolbar_title)
        TextView toolbarTitle;
        @BindView(R.id.toolbar_news)
        ImageView toolbarNews;
        @BindView(R.id.toolbar)
        Toolbar toolbar;
        @BindView(R.id.recycler_view)
        RecyclerView recyclerView;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);

            initToolbar();
            
            initRecyclerView();
            
        }

        private void initRecyclerView() {

        }

        private void initToolbar() {
            toolbarTitle.setText("逾期管理");
            toolbarBack.setOnClickListener(v -> {
                finish();
            });
            toolbarNews.setVisibility(View.VISIBLE);
            toolbarNews.setImageDrawable(getResources().getDrawable(R.drawable.list_search_s2));

        }

    }
}
