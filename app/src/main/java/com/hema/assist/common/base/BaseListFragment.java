package com.hema.assist.common.base;

import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hema.assist.common.adapter.DividerListItemDecoration;
import com.hema.assist.common.loger.AppLogger;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.hema.assist.app.App;
import com.wtw.p2p.R;
import com.hema.assist.common.adapter.BaseSingleAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Project: WangTouWang
 * Author: frank
 * Created: 2018/2/8:下午3:40
 * Email: 656266591@qq.com
 * Desc:
 */
public abstract class BaseListFragment<T> extends BaseFragment {

    protected BaseQuickAdapter singleAdapter;
    private EmptyViewHelper emptyViewHelper;


    @BindView(R.id.recycler_view)
    public RecyclerView recyclerView;
    @BindView(R.id.refresh_layout)
    public SmartRefreshLayout refreshLayout;
    @BindView(R.id.list_content)
    public RelativeLayout listContent;

    private DividerListItemDecoration divider;

    /**
     * 空数据视图
     */
    private View emptyView;

    /**
     * 固定头部视图
     */
    protected View fixedHeaderView;
    /**
     * 固定底部视图
     */
    protected View fixedFooterView;

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.layout_base_list;
    }

    @Override
    protected void onCreateFinished() {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(App.context);
        recyclerView.setLayoutManager(layoutManager);
        singleAdapter = getListAdapter();
        recyclerView.setAdapter(singleAdapter);

        //显示分割线
        if (showSplitView() ) {
            divider = new DividerListItemDecoration(getActivity(), DividerListItemDecoration.VERTICAL_LIST);
            recyclerView.addItemDecoration(divider);
        }

        configRefreshLayout();
        configHeaderAndFooterViews();
        configEmptyView();


    }

    /**
     * 配置RefreshLayout 子类可以重写覆盖。
     */
    protected void configRefreshLayout() {

        refreshLayout.setEnableOverScrollBounce(true);
        refreshLayout.setEnableRefresh(false);
        refreshLayout.setEnableLoadmore(false);
        refreshLayout.setEnableLoadmoreWhenContentNotFull(true);
        refreshLayout.setEnableFooterFollowWhenLoadFinished(true);
        refreshLayout.setEnableOverScrollDrag(true);
        refreshLayout.setEnableScrollContentWhenLoaded(true);
        refreshLayout.setEnableScrollContentWhenRefreshed(true);

        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                refresData();
            }
        });


        refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                loadMoreData();
            }
        });
    }

    /**
     * 设置空视图
     */
    protected void configEmptyView() {
        emptyView = getEmptyView();
        if (emptyView != null) {
            emptyView.setClickable(true);
            emptyView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AppLogger.d("占位图点击");
                    emptyViewHelper.setRefreshing(true);
                    refresData();
                }
            });
            //设置空视图
            singleAdapter.setEmptyView(emptyView);
        }
    }

    /**
     * 设置头部视图和尾部视图
     */
    protected void configHeaderAndFooterViews() {

        View headerView = getHeaderView();
        View footerView = getFooterView();
        if (headerView != null) {
            singleAdapter.addHeaderView(headerView);
        }
        if (footerView != null) {
            singleAdapter.addFooterView(footerView);
        }


        configFixedHeaderView();
        configFixedFooterView();

    }

    //设置固定头部视图
    protected void configFixedHeaderView() {

        fixedHeaderView = getFixedHeaderView();
        if (fixedHeaderView != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
            listContent.addView(fixedHeaderView, layoutParams);

            int id = fixedHeaderView.getId();
            if (id < 0) {
                id = R.id.id_fragment_list_fixed_header;
                fixedHeaderView.setId(id);
            }

            RelativeLayout.LayoutParams swipeLayoutLayoutParams = (RelativeLayout.LayoutParams) refreshLayout.getLayout().getLayoutParams();
            swipeLayoutLayoutParams.addRule(RelativeLayout.BELOW, id);
            refreshLayout.getLayout().setLayoutParams(swipeLayoutLayoutParams);
        }

    }

    //设置固定底部视图
    protected void configFixedFooterView() {

        fixedFooterView = getFixedFooterView();
        if (fixedFooterView != null) {

            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
            listContent.addView(fixedFooterView, layoutParams);

            int id = fixedFooterView.getId();
            if (id < 0) {
                id = R.id.id_fragment_list_fixed_footer;
                fixedFooterView.setId(id);
            }

            RelativeLayout.LayoutParams swipeLayoutLayoutParams = (RelativeLayout.LayoutParams) refreshLayout.getLayout().getLayoutParams();
            swipeLayoutLayoutParams.addRule(RelativeLayout.ABOVE, id);
            refreshLayout.getLayout().setLayoutParams(swipeLayoutLayoutParams);

        }


    }

    protected BaseQuickAdapter getListAdapter() {
        BaseQuickAdapter<T, BaseViewHolder> adapter = new BaseListSingleAdapter();
        return adapter;
    }

    protected void setSingleRecyclerData(List<T> data) {
        endLoading(true);

        if (singleAdapter != null) {

            singleAdapter.setNewData(data);

        }
    }

    protected void endLoading(boolean canLoadMore) {

//        if (singleAdapter != null) {
//            singleAdapter.setEnableLoadMore(true);
//        }


        if (refreshLayout.isRefreshing()) {
            refreshLayout.finishRefresh();
        }

        if (refreshLayout.isLoading()) {
            refreshLayout.finishLoadmore();
        }

        if (canLoadMore) {
            refreshLayout.setEnableLoadmore(true);
        } else {
            //            refreshLayout.setEnableLoadmore(false);
            refreshLayout.finishLoadmoreWithNoMoreData();
        }


    }

    /**
     * 显示分割线
     *
     * @return
     */
    protected boolean showSplitView() {
        return true;
    }


    /**
     * 刷新数据
     */
    protected void refresData() {
        emptyViewHelper.setRefreshing(false);
        refreshLayout.finishRefresh();
    }

    /**
     * 加载更多
     */
    protected void loadMoreData() {
        refreshLayout.finishLoadmore();
    }

    /**
     * 获取item resId
     *
     * @return
     */
    protected abstract int getAdapterItemResId();

    /**
     * 绑定 adapter data
     *
     * @param helper
     * @param item
     */
    protected abstract void convert(BaseViewHolder helper, T item);

    /**
     * 获取空的View
     *
     * @return
     */
    protected View getEmptyView() {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.empty_default, null);
        emptyViewHelper = new EmptyViewHelper(view);
        emptyViewHelper.setImageResId(R.mipmap.def_shuju);
        emptyViewHelper.setTextHint("没有找到相关数据");
        return view;
    }


    /**
     * 获取头布局
     *
     * @return
     */
    protected View getHeaderView() {
        return null;
    }

    /**
     * 获取尾布局
     *
     * @return
     */
    protected View getFooterView() {
        return null;
    }

    /**
     * 获取固定在头部的View
     *
     * @return
     */
    protected View getFixedHeaderView() {
        return null;
    }

    protected View getFixedFooterView() {
        return null;
    }

    class BaseListSingleAdapter extends BaseSingleAdapter<T, BaseViewHolder> {

        public BaseListSingleAdapter() {
            super(BaseListFragment.this.getAdapterItemResId());
        }

        public BaseListSingleAdapter(@Nullable List<T> data) {
            super(BaseListFragment.this.getAdapterItemResId(), data);
        }

        @Override
        protected void convert(BaseViewHolder helper, T item) {
            BaseListFragment.this.convert(helper, item);
        }

        /**
         * 设置数据
         *
         * @param data
         */
        public void setData(List<T> data) {
            mData = data == null ? new ArrayList<T>() : data;
        }

    }

    class EmptyViewHelper {
        private View view;
        public boolean isRefreshing;

        @BindView(R.id.iv_empty)
        ImageView emptyImageView;
        @BindView(R.id.tv_retry_defaultNet)
        TextView emptyTextView;
        @BindView(R.id.loding)
        ProgressBar loadingBar;
        @BindView(R.id.tv_tips)
        TextView tvTips;

        EmptyViewHelper(View view) {
            this.view = view;
            ButterKnife.bind(this, view);
        }

        public void setImageResId(int resId) {
            if (emptyImageView != null) {
                emptyImageView.setImageResource(resId);
            }
        }

        public void setTextHint(CharSequence textHint) {
            if (emptyTextView != null) {
                emptyTextView.setText(textHint);
            }
        }

        public boolean isRefreshing() {
            return isRefreshing;
        }

        public void setRefreshing(boolean refreshing) {
            isRefreshing = refreshing;
            if (isRefreshing) {
                loadingBar.setVisibility(View.VISIBLE);
                emptyTextView.setVisibility(View.GONE);
                tvTips.setVisibility(View.GONE);
            } else {
                loadingBar.setVisibility(View.GONE);
                emptyTextView.setVisibility(View.VISIBLE);
                tvTips.setVisibility(View.VISIBLE);
            }
        }
    }


}
