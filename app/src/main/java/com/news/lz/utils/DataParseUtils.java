package com.news.lz.utils;

import com.avos.avoscloud.AVObject;
import com.news.lz.entity.NewItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by caibingyuan on 2018/1/12.
 */

public class DataParseUtils {
    public static final String NEWS_CLASS_NAME = "News";
    private static final String KEY_NEWS_ID = "news_id";
    private static final String KEY_NEWS_TITLE = "news_title";
    private static final String KEY_NEWS_CONTENT = "news_content";
    private static final String KEY_NEWS_PIC_URL = "news_pic_url";

    public static List<NewItem> parseAVObjectToNewItem(List<AVObject> objects) {
        if (CollectionUtils.isListEmpty(objects)) {
            return new ArrayList<NewItem>();
        }

        List<NewItem> newItemList = new ArrayList<>(objects.size());
        int index = 0;
        for (AVObject object : objects) {
            NewItem newItem = new NewItem();
            newItem.setNewId(object.getInt(KEY_NEWS_ID));
            newItem.setNewContent(object.getString(KEY_NEWS_CONTENT));
            newItem.setNewTitle(object.getString(KEY_NEWS_CONTENT));
            newItem.setNewPicUrl(object.getString(KEY_NEWS_PIC_URL));
            newItemList.add(index, newItem);
            index++;
        }

        return newItemList;
    }
}
