package com.news.lz.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.avos.avoscloud.LogUtil;
import com.news.lz.R;
import com.news.lz.adapter.BaseRecyclerViewAdapter;
import com.news.lz.engine.ServiceDataManager;
import com.news.lz.engine.callback.DataOperateCallback;
import com.news.lz.entity.model.BaseItem;

import java.util.List;

import static com.news.lz.entity.statistics.ItemTypeConst.ITEM_TYPE_VIDEO;

/**
 * 推荐视频页面
 * Created by caibingyuan on 2017/12/27.
 */

public class RecommendVideoFragmet extends Fragment {
    private static final int SLIDE_DISTANCE_THRESOLD = 400;
    private RecyclerView mRecyclerView;
    private BaseRecyclerViewAdapter mAdapter;

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
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            private int mDistanceY = 0;
            private int mCurrentItemPosition = 0;

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                mDistanceY += dy;
            }

           @Override
           public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
               super.onScrollStateChanged(recyclerView, newState);
               if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    if (mDistanceY > SLIDE_DISTANCE_THRESOLD) {
                        mCurrentItemPosition ++;
                    } else if (mDistanceY < -SLIDE_DISTANCE_THRESOLD) {
                        mCurrentItemPosition --;
                        if (mCurrentItemPosition < 0) {
                            mCurrentItemPosition = 0;
                        }
                    }
                   mRecyclerView.scrollToPosition(mCurrentItemPosition);
                   mDistanceY = 0;
               }
           }});
        mAdapter = new BaseRecyclerViewAdapter(ITEM_TYPE_VIDEO);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void initDatas() {
        ServiceDataManager.getInstance().readVideo(new DataOperateCallback() {
            @Override
            public void onReadSuccess(String url) {

            }

            @Override
            public void onReadSuccess(List<? extends BaseItem> itemList) {
                mAdapter.setDatas(itemList);
            }
        });
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
