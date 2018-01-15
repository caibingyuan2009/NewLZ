package com.news.lz.engine;

import android.util.Log;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.avos.avoscloud.FindCallback;
import com.news.lz.engine.callback.DataOperateCallback;
import com.news.lz.entity.model.NewItem;
import com.news.lz.entity.model.VideoItem;
import com.news.lz.utils.DataParseUtils;
import com.news.lz.utils.SortUtils;

import java.util.List;

import static com.news.lz.entity.statistics.ServiceFieldConst.NEWS_CLASS_NAME;
import static com.news.lz.entity.statistics.ServiceFieldConst.VIDEO_CLASS_NAME;

/**
 * Created by caibingyuan on 2018/1/11.
 */

public class ServiceDataManager {
    private static ServiceDataManager sServiceDataManager;

    public static ServiceDataManager getInstance() {
        if (sServiceDataManager == null) {
            synchronized (ServiceDataManager.class) {
                if (sServiceDataManager == null) {
                    sServiceDataManager = new ServiceDataManager();
                }
            }
        }
        return sServiceDataManager;
    }

    private ServiceDataManager() {

    }

    public void readNews(final DataOperateCallback callback) {
        AVQuery<AVObject> queryNews = new AVQuery<>(NEWS_CLASS_NAME);
        queryNews.findInBackground(new FindCallback<AVObject>() {
            @Override
            public void done(List<AVObject> list, AVException e) {
                List<NewItem> newItemList = DataParseUtils.parseAVObjectToNewItem(list);
                SortUtils.sortItemList(newItemList);
                callback.onReadSuccess(newItemList.get(0).getNewPicUrl());
            }
        });
    }

    public void readVideo(final DataOperateCallback callback) {
        AVQuery<AVObject> queryVideo = new AVQuery<>(VIDEO_CLASS_NAME);
        queryVideo.findInBackground(new FindCallback<AVObject>() {
            @Override
            public void done(List<AVObject> list, AVException e) {
                List<VideoItem> videoItemList = DataParseUtils.parseAVObjectToVideoItem(list);
                SortUtils.sortItemList(videoItemList);
                callback.onReadSuccess(videoItemList);
            }
        });
    }

    private void writeService() {
    }

}
