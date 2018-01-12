package com.news.lz.engine;

import android.util.Log;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.avos.avoscloud.FindCallback;
import com.news.lz.engine.callback.DataOperateCallback;
import com.news.lz.entity.NewItem;
import com.news.lz.utils.DataParseUtils;
import com.news.lz.utils.SortUtils;

import java.util.List;

import static com.news.lz.utils.DataParseUtils.NEWS_CLASS_NAME;

/**
 * Created by caibingyuan on 2018/1/11.
 */

public class ServiceDataManager {
    private static final String READ_CULTURE_CLASS_NAME = "ReadCulture";
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
        AVQuery<AVObject> query = new AVQuery<>(NEWS_CLASS_NAME);
        query.findInBackground(new FindCallback<AVObject>() {
            @Override
            public void done(List<AVObject> list, AVException e) {
                List<NewItem> newItemList = DataParseUtils.parseAVObjectToNewItem(list);
                SortUtils.sortNewsList(newItemList);
                for (NewItem newItem : newItemList) {
                    Log.d("caibingyuan", "News Title = " + newItem.getNewTitle());
                    Log.d("caibingyuan", "News Content = " + newItem.getNewContent());
                    Log.d("caibingyuan", "News Pic Url = " + newItem.getNewPicUrl());
                }

                callback.onDone(newItemList.get(0).getNewPicUrl());
            }
        });
    }

    public void readRedCulture() {
        AVQuery<AVObject> query = new AVQuery<>(NEWS_CLASS_NAME);
        query.findInBackground(new FindCallback<AVObject>() {
            @Override
            public void done(List<AVObject> list, AVException e) {
                List<NewItem> newItemList = DataParseUtils.parseAVObjectToNewItem(list);
                SortUtils.sortNewsList(newItemList);
                for (NewItem newItem : newItemList) {
                    Log.d("caibingyuan", "News Title = " + newItem.getNewTitle());
                    Log.d("caibingyuan", "News Content = " + newItem.getNewContent());
                }
            }
        });
    }

    private void writeService() {
    }

}
