package com.news.lz.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.news.lz.R;
import com.news.lz.adapter.MainPagerAdapter;
import com.news.lz.fragment.MeFragment;
import com.news.lz.fragment.NewsFragment;
import com.news.lz.fragment.RedCultureFragmet;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    private static final int TAB_POSITION_NEWS = 0;
    private static final int TAB_POSITION_RED_CULTURE = 1;
    private static final int TAB_POSITION_ME = 2;

    @BindView(R.id.view_pager)
    public ViewPager mViewPager;

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
        mMainPagerAdapter = new MainPagerAdapter(getSupportFragmentManager(), getPageList());
        mViewPager.setAdapter(mMainPagerAdapter);

        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.getTabAt(TAB_POSITION_NEWS).setText(R.string.main_tab_news);
        mTabLayout.getTabAt(TAB_POSITION_RED_CULTURE).setText(R.string.main_tab_red_culture);
        mTabLayout.getTabAt(TAB_POSITION_ME).setText(R.string.main_tab_me);
    }

    private List<Fragment> getPageList() {
        List<Fragment> list = new ArrayList<>();
        list.add(new NewsFragment());
        list.add(new RedCultureFragmet());
        list.add(new MeFragment());
        return list;
    }

}
