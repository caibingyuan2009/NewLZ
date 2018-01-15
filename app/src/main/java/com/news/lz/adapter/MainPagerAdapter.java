package com.news.lz.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.news.lz.utils.CollectionUtils;

import java.util.List;

/**
 * Created by caibingyuan on 2017/12/27.
 */

public class MainPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> mPages = null;

    public MainPagerAdapter(FragmentManager fm, List<Fragment> lists) {
        super(fm);
        mPages = lists;
    }

    @Override
    public Fragment getItem(int position) {
        if (CollectionUtils.isListEmpty(mPages) || mPages.size() <= position) {
            return null;
        }

        return mPages.get(position);
    }

    @Override
    public int getCount() {
        if (CollectionUtils.isListEmpty(mPages)) {
            return 0;
        }
        return mPages.size();
    }

}
