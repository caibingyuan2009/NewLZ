package com.news.lz.activity;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.news.lz.R;
import com.news.lz.adapter.MainPagerAdapter;
import com.news.lz.fragment.MainFragment;
import com.news.lz.fragment.MeFragment;
import com.news.lz.fragment.NewsFragment;
import com.news.lz.widget.CustomViewPager;
import com.news.lz.widget.TabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    private static final int TAB_POSITION_MAIN = 0;
    private static final int TAB_POSITION_NEWS = 1;
    private static final int TAB_POSITION_ME = 2;

    @BindView(R.id.view_pager)
    public CustomViewPager mViewPager;

    @BindView(R.id.tabLayout)
    public TabLayout mTabLayout;

    private MainPagerAdapter mMainPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initViews();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void initViews() {
        List<Fragment> pageList = getPageList();
        mMainPagerAdapter = new MainPagerAdapter(getSupportFragmentManager(), pageList);
        mViewPager.setAdapter(mMainPagerAdapter);
        mViewPager.setCanScroll(false);
        mViewPager.setOffscreenPageLimit(pageList.size());

        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.getTabAt(TAB_POSITION_MAIN).setText(R.string.main_tab_1);
        mTabLayout.getTabAt(TAB_POSITION_NEWS).setText(R.string.main_tab_2);
        mTabLayout.getTabAt(TAB_POSITION_ME).setText(R.string.main_tab_3);
    }

    private List<Fragment> getPageList() {
        List<Fragment> list = new ArrayList<>();
        list.add(new MainFragment());
        list.add(new NewsFragment());
        list.add(new MeFragment());
        return list;
    }

}
