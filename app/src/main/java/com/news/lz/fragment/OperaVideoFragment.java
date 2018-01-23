package com.news.lz.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.news.lz.R;

/**
 * Created by caibingyuan on 2018/1/16.
 */

public class OperaVideoFragment extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState){
        View rootView = LayoutInflater.from(getActivity()).inflate(R.layout.layout_operate_fragment, null);
        initViews(rootView);

        initDatas();
        return rootView;
    }

    private void initViews(View rootView) {

    }

    private void initDatas() {

    }
}
