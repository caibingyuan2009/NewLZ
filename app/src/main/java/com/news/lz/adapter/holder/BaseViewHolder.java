package com.news.lz.adapter.holder;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.news.lz.entity.model.BaseItem;

import butterknife.ButterKnife;

/**
 * Created by caibingyuan on 2018/1/15.
 */

public abstract class BaseViewHolder extends RecyclerView.ViewHolder {
    private View mItemView;

    public BaseViewHolder(ViewGroup parentGroup, int layoutId) {
        this(LayoutInflater.from(parentGroup.getContext()).inflate(layoutId, parentGroup, false));
    }

    public BaseViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(itemView);
        mItemView = itemView;
    }

    public abstract void updateViews(BaseItem item);

    // Activity或者Fragment生命周期回调
    public void onStart() {

    }

    public void onResume() {

    }

}
