package com.news.lz.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.news.lz.R;

/**
 * Created by caibingyuan on 2018/1/15.
 */

public class MainFragment extends Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState){
        View rootView = LayoutInflater.from(getActivity()).inflate(R.layout.layout_main_fragment, null);
        return rootView;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
