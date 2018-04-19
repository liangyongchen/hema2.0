package com.hema.assist.feature.apply.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.hema.assist.common.views.BannerLayout;
import com.wtw.p2p.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 河马安卓 on 2018/4/19.
 */

public class BannerAdapter extends RecyclerView.Adapter<BannerAdapter.ChildViewHolder> {

    private Context mContext;

    private List<String> mData;

    private BannerLayout.OnBannerItemClickListener onBannerItemClickListener;

    public BannerAdapter(Context context, List<String> list) {
        this.mContext = context;
        this.mData = list;
    }

    public void setOnBannerItemClickListener(BannerLayout.OnBannerItemClickListener onBannerItemClickListener) {
        this.onBannerItemClickListener = onBannerItemClickListener;
    }


    @Override
    public ChildViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ChildViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image, parent, false));
    }


    @Override
    public void onBindViewHolder(ChildViewHolder holder, final int position) {

        if (mData == null && mData.size() <= 0) {
            return;
        }

        // 去重
        final int p = position % mData.size();

        holder.setImageView(p);

    }


    @Override
    public int getItemCount() {
        if (mData != null)
            return mData.size();
        else
            return 0;
    }


    class ChildViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.image)
        ImageView imageView;

        public ChildViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }


        public void setImageView(final int position) {
            String url = mData.get(position);

            Glide.with(mContext).load(url).into(imageView);

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onBannerItemClickListener != null) {
                        onBannerItemClickListener.onItemClick(position);
                    }
                }
            });

        }
    }
}
