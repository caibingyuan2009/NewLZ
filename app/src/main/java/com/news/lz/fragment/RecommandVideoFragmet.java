package com.news.lz.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.news.lz.R;
import com.news.lz.adapter.BaseRecyclerViewAdapter;
import com.news.lz.engine.ServiceDataManager;
import com.news.lz.engine.callback.DataOperateCallback;
import com.news.lz.entity.model.BaseItem;

import java.util.List;

import static com.news.lz.entity.statistics.ItemTypeConst.ITEM_TYPE_VIDEO;

/**
 * 红土文化页面
 * Created by caibingyuan on 2017/12/27.
 */

public class RecommandVideoFragmet extends Fragment {
    private RecyclerView mRecyclerView;
    private BaseRecyclerViewAdapter mAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState){
        View rootView = LayoutInflater.from(getActivity()).inflate(R.layout.layout_redculture_fragment, null);
        initViews(rootView);

        initDatas();
        return rootView;
    }

    private void initViews(View rootView) {
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
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
