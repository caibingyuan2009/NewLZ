package com.news.lz.utils;

import com.news.lz.entity.model.BaseItem;
import com.news.lz.entity.model.NewItem;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by caibingyuan on 2018/1/12.
 */

public class SortUtils {

    public static void sortItemList(List<? extends BaseItem> list) {
        Collections.sort(list, new Comparator<BaseItem>() {
            @Override
            public int compare(BaseItem item1, BaseItem item2) {
                int id1 = item1.getId();
                int id2 = item2.getId();
                if (id1 > id2) {
                    return 1;
                } else if(id1 < id2) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
    }
}
