package com.news.lz.activity;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TableLayout;

import com.news.lz.R;
import com.news.lz.adapter.MainPagerAdapter;
import com.news.lz.fragment.MeFragment;
import com.news.lz.fragment.NewsFragment;
import com.news.lz.fragment.RedCultureFragmet;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener{

    @BindView(R.id.view_pager)
    public ViewPager mViewPager;

    @BindView(R.id.tabLayout)
    public TableLayout mTableLayout;

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
    }

    private List<Fragment> getPageList() {
        List<Fragment> list = new ArrayList<>();
        list.add(new NewsFragment());
        list.add(new RedCultureFragmet());
        list.add(new MeFragment());
        return list;
    }

}
