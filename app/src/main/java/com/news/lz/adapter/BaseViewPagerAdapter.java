package com.news.lz.adapter;

import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by caibingyuan on 2018/1/24.
 */

public class BaseViewPagerAdapter extends PagerAdapter {
    private List<View> mListViews;

    public BaseViewPagerAdapter(List<View> listViews) {
        this.mListViews = listViews;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object)  {
        container.removeView(mListViews.get(position));//删除页卡
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position){
        container.addView(mListViews.get(position), 0);
        return mListViews.get(position);
    }
    @Override
    public int getCount() {
        return  mListViews.size();
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0==arg1;
    }
}
