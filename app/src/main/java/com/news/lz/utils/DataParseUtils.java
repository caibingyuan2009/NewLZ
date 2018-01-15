package com.news.lz.utils;

import com.avos.avoscloud.AVObject;
import com.news.lz.entity.model.NewItem;
import com.news.lz.entity.model.VideoItem;

import java.util.ArrayList;
import java.util.List;

import static com.news.lz.entity.statistics.ServiceFieldConst.KEY_NEWS_CONTENT;
import static com.news.lz.entity.statistics.ServiceFieldConst.KEY_NEWS_ID;
import static com.news.lz.entity.statistics.ServiceFieldConst.KEY_NEWS_PIC_URL;
import static com.news.lz.entity.statistics.ServiceFieldConst.KEY_VIDEO_COVER_URL;
import static com.news.lz.entity.statistics.ServiceFieldConst.KEY_VIDEO_ID;
import static com.news.lz.entity.statistics.ServiceFieldConst.KEY_VIDEO_TITLE;
import static com.news.lz.entity.statistics.ServiceFieldConst.KEY_VIDEO_URL;

/**
 * Created by caibingyuan on 2018/1/12.
 */

public class DataParseUtils {

    public static List<NewItem> parseAVObjectToNewItem(List<AVObject> objects) {
        if (CollectionUtils.isListEmpty(objects)) {
            return new ArrayList<NewItem>();
        }

        List<NewItem> newItemList = new ArrayList<>(objects.size());
        int index = 0;
        for (AVObject object : objects) {
            NewItem newItem = new NewItem();
            newItem.setId(object.getInt(KEY_NEWS_ID));
            newItem.setNewContent(object.getString(KEY_NEWS_CONTENT));
            newItem.setNewTitle(object.getString(KEY_NEWS_CONTENT));
            newItem.setNewPicUrl(object.getString(KEY_NEWS_PIC_URL));
            newItemList.add(index, newItem);
            index++;
        }

        return newItemList;
    }

    public static List<VideoItem> parseAVObjectToVideoItem(List<AVObject> objects) {
        if (CollectionUtils.isListEmpty(objects)) {
            return new ArrayList<VideoItem>();
        }

        List<VideoItem> videoItemList = new ArrayList<>(objects.size());
        int index = 0;
        for (AVObject object : objects) {
            VideoItem videoItem = new VideoItem();
            videoItem.setId(object.getInt(KEY_VIDEO_ID));
            videoItem.setVideoTitle(object.getString(KEY_VIDEO_TITLE));
            videoItem.setVideoCoverUrl(object.getString(KEY_VIDEO_COVER_URL));
            videoItem.setVideoUrl(object.getString(KEY_VIDEO_URL));
            videoItemList.add(index, videoItem);
            index++;
        }

        return videoItemList;
    }
}
