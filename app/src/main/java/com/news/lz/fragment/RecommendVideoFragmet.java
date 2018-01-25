package com.news.lz.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.news.lz.R;
import com.news.lz.adapter.BaseViewPagerAdapter;
import com.news.lz.engine.ServiceDataManager;
import com.news.lz.engine.callback.DataOperateCallback;
import com.news.lz.entity.model.BaseItem;
import com.news.lz.utils.CollectionUtils;
import com.news.lz.widget.CustomViewPager;
import com.news.lz.widget.RecommendVideoView;
import com.news.lz.widget.VerticalViewPager;
import com.news.lz.widget.transformer.DefaultTransformer;

import java.util.ArrayList;
import java.util.List;

import static android.view.View.OVER_SCROLL_NEVER;

/**
 * 推荐视频页面
 * Created by caibingyuan on 2017/12/27.
 */

public class RecommendVideoFragmet extends Fragment {
    private VerticalViewPager mVerticalViewPager;
    List<View> mViewList = new ArrayList<>(0);

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState){
        View rootView = LayoutInflater.from(getActivity()).inflate(R.layout.layout_recommend_video_fragment, null);
        initViews(rootView);

        initDatas();
        return rootView;
    }

    private void initViews(View rootView) {
        mVerticalViewPager = (VerticalViewPager) rootView.findViewById(R.id.vertical_viewpager);
        mVerticalViewPager.setPageTransformer(true, new DefaultTransformer());
        mVerticalViewPager.setOverScrollMode(OVER_SCROLL_NEVER);
        mVerticalViewPager.setOffscreenPageLimit(10);
        mVerticalViewPager.setAdapter(new BaseViewPagerAdapter(mViewList));
    }

    private void initDatas() {
        ServiceDataManager.getInstance().readVideo(new DataOperateCallback() {
            @Override
            public void onReadSuccess(String url) {

            }

            @Override
            public void onReadSuccess(List<? extends BaseItem> itemList) {
                if (CollectionUtils.isListEmpty(itemList)) {
                    return;
                }
                mViewList.clear();

                for (BaseItem item : itemList) {
                    RecommendVideoView recommendVideoView = new RecommendVideoView(getActivity());
                    recommendVideoView.updateViews(item);
                    mViewList.add(recommendVideoView);
                }

                mVerticalViewPager.getAdapter().notifyDataSetChanged();
            }
        });

        mVerticalViewPager.addOnPageChangeListener(new CustomViewPager.OnPageChangeListener() {
            private int mLastPosition = 0;

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(final int position) {
                if (!checkPageAvaible(position)) {
                    return;
                }
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ((RecommendVideoView) mViewList.get(mLastPosition)).stopVideo();
                        ((RecommendVideoView) mViewList.get(position)).restartVideo();
                        mLastPosition = position;
                    }
                }, 500);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private boolean checkPageAvaible(int position) {
        if (CollectionUtils.isListEmpty(mViewList) || mViewList.size() <= position) {
            return false;
        }

        return true;
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

}
