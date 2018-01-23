package com.news.lz.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.news.lz.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by caibingyuan on 2018/1/15.
 */

public class MainFragment extends Fragment implements View.OnClickListener {
    private static final int TOPIC_RECOMMAND = 1;
    private static final int TOPIC_OPERATE = 2;
    @BindView(R.id.tv_recommand)
    public TextView mRecommandTv;
    @BindView(R.id.tv_operate)
    public TextView mOperateTv;
    @BindView(R.id.layout_fragment)
    public FrameLayout mFrameLayout;

    private RecommendVideoFragmet mRecommendVideoFragmet;
    private OperaVideoFragment mOperaVideoFragment;
    private Fragment mCurrentFragment;
    private int mCurrentFragmentIndex = -1;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState){
        View rootView = LayoutInflater.from(getActivity()).inflate(R.layout.layout_main_fragment, null);
        ButterKnife.bind(this, rootView);
        updateViews();
        return rootView;
    }

    private void updateViews() {
        selectTopic(TOPIC_RECOMMAND);
        mRecommandTv.setOnClickListener(this);
        mOperateTv.setOnClickListener(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View view) {
        if (view == mRecommandTv) {
            selectTopic(TOPIC_RECOMMAND);
        } else if (view == mOperateTv) {
            selectTopic(TOPIC_OPERATE);
        }
    }

    private void selectTopic(int topicIndex) {
        if (topicIndex == TOPIC_RECOMMAND) {
            mRecommandTv.setTextColor(Color.WHITE);
            mOperateTv.setTextColor(Color.parseColor("#9a9a9a"));
        } else if (topicIndex == TOPIC_OPERATE) {
            mRecommandTv.setTextColor(Color.parseColor("#9a9a9a"));
            mOperateTv.setTextColor(Color.WHITE);
        }

        switchToFragment(topicIndex);
    }

    private void switchToFragment(int fragmentIndex) {
        if (fragmentIndex == TOPIC_RECOMMAND) {
            switchToRecommendFragment();
        } else if (fragmentIndex == TOPIC_OPERATE){
            switchToOperateFragment();
        }
    }

    private void switchToRecommendFragment() {
        if (isSameFragment(TOPIC_RECOMMAND)) {
            return;
        }

        FragmentTransaction transaction = getChildFragmentManager()
                .beginTransaction();
        if (mRecommendVideoFragmet == null) {
            // 懒加载
            mRecommendVideoFragmet = new RecommendVideoFragmet();
        }

        if (mCurrentFragment == null || !mRecommendVideoFragmet.isAdded()) {
            // 首次初始化
            transaction.add(R.id.layout_fragment, mRecommendVideoFragmet);
        } else {
            if (mRecommendVideoFragmet.isAdded()) {
                transaction.hide(mCurrentFragment).show(mRecommendVideoFragmet);
            } else {
                transaction.hide(mCurrentFragment).add(R.id.layout_fragment, mRecommendVideoFragmet);
            }
        }

        transaction.commit();

        mCurrentFragment = mRecommendVideoFragmet;
        mCurrentFragmentIndex = TOPIC_RECOMMAND;
    }

    private void switchToOperateFragment() {
        if (isSameFragment(TOPIC_OPERATE)) {
            return;
        }

        FragmentTransaction transaction = getChildFragmentManager()
                .beginTransaction();
        if (mOperaVideoFragment == null) {
            // 懒加载
            mOperaVideoFragment = new OperaVideoFragment();
        }

        if (mCurrentFragment == null || !mOperaVideoFragment.isAdded()) {
            // 首次初始化
            transaction.add(R.id.layout_fragment, mOperaVideoFragment);
        } else {
            if (mOperaVideoFragment.isAdded()) {
                transaction.hide(mCurrentFragment).show(mOperaVideoFragment);
            } else {
                transaction.hide(mCurrentFragment).add(R.id.layout_fragment, mOperaVideoFragment);
            }
        }

        transaction.commit();

        mCurrentFragment = mOperaVideoFragment;
        mCurrentFragmentIndex = TOPIC_OPERATE;
    }

    private boolean isSameFragment(int currentFragmentIndex) {
        return mCurrentFragmentIndex == currentFragmentIndex;
    }
}
