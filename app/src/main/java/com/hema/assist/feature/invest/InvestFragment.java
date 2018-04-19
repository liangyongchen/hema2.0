package com.hema.assist.feature.invest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wtw.p2p.R;

import butterknife.ButterKnife;

/**
 * Project: WangTouWang
 * Author: frank
 * Created: 2018/1/27:下午10:58
 * Email: 656266591@qq.com
 * Desc:
 */

public class InvestFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_invest_layout, container, false);
        ButterKnife.bind(this, view);
        return view;
    }
}
