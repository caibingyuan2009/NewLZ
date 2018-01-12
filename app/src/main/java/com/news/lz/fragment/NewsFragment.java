package com.news.lz.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.SaveCallback;
import com.bumptech.glide.Glide;
import com.news.lz.R;
import com.news.lz.engine.ServiceDataManager;
import com.news.lz.engine.callback.DataOperateCallback;

/**
 * 新闻页面
 * Created by caibingyuan on 2017/12/27.
 */

public class NewsFragment extends Fragment {
    private ImageView mIv;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState){
        View rootView = LayoutInflater.from(getActivity()).inflate(R.layout.layout_news_fragment, null);
        mIv = (ImageView) rootView.findViewById(R.id.iv_test);
        testService();
        return rootView;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    private void testService() {
        ServiceDataManager.getInstance().readNews(new DataOperateCallback() {
            @Override
            public void onDone(final String url) {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Glide.with(NewsFragment.this)
                                .load(url)
                                .into(mIv);
                    }
                });
            }
        });
    }

    private void uploadDatas() {

    }

    private void readDatas() {

    }
}
