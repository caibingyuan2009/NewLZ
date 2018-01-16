package com.news.lz.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
        mRecommandTv.setOnClickListener(this);
        mOperateTv.setOnClickListener(this);
        selectTopic(TOPIC_RECOMMAND);
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
    }
}
