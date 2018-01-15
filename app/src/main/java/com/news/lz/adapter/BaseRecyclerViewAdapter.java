package com.news.lz.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.news.lz.adapter.holder.BaseViewHolder;
import com.news.lz.adapter.holder.NewViewHolder;
import com.news.lz.adapter.holder.VideoViewHolder;
import com.news.lz.entity.model.BaseItem;
import com.news.lz.utils.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

import static com.news.lz.entity.statistics.ItemTypeConst.ITEM_TYPE_DEFAULT;
import static com.news.lz.entity.statistics.ItemTypeConst.ITEM_TYPE_NEWS;
import static com.news.lz.entity.statistics.ItemTypeConst.ITEM_TYPE_VIDEO;

/**
 * Created by caibingyuan on 2018/1/15.
 */

public class BaseRecyclerViewAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private List<BaseItem> mItems = new ArrayList<>(0);
    private int mItemType = ITEM_TYPE_DEFAULT;

    public BaseRecyclerViewAdapter(int type) {
        mItemType = type;
    }

    public void setDatas(List<? extends BaseItem> items) {
        mItems.clear();
        mItems.addAll(items);
        notifyDataSetChanged();
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return createViewHolder(parent);
    }

    private BaseViewHolder createViewHolder(ViewGroup parent) {
        BaseViewHolder viewHolder = null;
        switch (mItemType) {
            case ITEM_TYPE_NEWS:
                viewHolder = new NewViewHolder(parent);
                break;
            case ITEM_TYPE_VIDEO:
                viewHolder = new VideoViewHolder(parent);
                break;
            default:
                break;
        }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        if (!CollectionUtils.isListEmpty(mItems) && mItems.size() > position) {
            holder.updateViews(mItems.get(position));
        }
    }

    @Override
    public int getItemCount() {
        if (CollectionUtils.isListEmpty(mItems)) {
            return 0;
        }

        return mItems.size();
    }
}
