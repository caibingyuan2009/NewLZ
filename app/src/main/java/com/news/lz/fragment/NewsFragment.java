package com.news.lz.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.SaveCallback;
import com.news.lz.R;
import com.news.lz.engine.ServiceDataManager;

/**
 * 新闻页面
 * Created by caibingyuan on 2017/12/27.
 */

public class NewsFragment extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        testService();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState){
        View rootView = LayoutInflater.from(getActivity()).inflate(R.layout.layout_news_fragment, null);
        return rootView;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    private void testService() {
        ServiceDataManager.getInstance().readService();
    }

    private void uploadDatas() {

    }

    private void readDatas() {

    }
}
