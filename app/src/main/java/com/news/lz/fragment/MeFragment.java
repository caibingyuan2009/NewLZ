package com.news.lz.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.news.lz.R;

/**
 * me页面
 * Created by caibingyuan on 2017/12/27.
 */

public class MeFragment extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState){
        View rootView = LayoutInflater.from(getActivity()).inflate(R.layout.layout_me_fragment, null);
        return rootView;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
