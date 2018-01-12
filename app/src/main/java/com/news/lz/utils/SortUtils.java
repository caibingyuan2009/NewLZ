package com.news.lz.utils;

import com.avos.avoscloud.AVObject;
import com.news.lz.entity.NewItem;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by caibingyuan on 2018/1/12.
 */

public class SortUtils {

    public static void sortNewsList(List<NewItem> list) {
        Collections.sort(list, new Comparator<NewItem>() {
            @Override
            public int compare(NewItem newItem1, NewItem newItem2) {
                int newId1 = newItem1.getNewId();
                int newId2 = newItem2.getNewId();

                if (newId1 > newId2) {
                    return 1;
                } else if(newId1 < newId2) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
    }
}
