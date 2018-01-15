package com.news.lz.engine.callback;

import com.news.lz.entity.model.BaseItem;

import java.util.List;

/**
 * Created by caibingyuan on 2018/1/12.
 */

public interface DataOperateCallback {
    void onReadSuccess(String url);
    void onReadSuccess(List<? extends BaseItem> itemList);
}
