package com.news.lz.engine;

import android.util.Log;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.avos.avoscloud.FindCallback;
import com.avos.avoscloud.GetCallback;
import com.news.lz.utils.CollectionUtils;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by caibingyuan on 2018/1/11.
 */

public class ServiceDataManager {
    private static final String NEWS_CLASS_NAME = "News";
    private static final String KEY_NEWS_ID = "news_id";
    private static final String KEY_NEWS_TITLE = "news_title";
    private static final String KEY_NEWS_CONTENT = "news_content";

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

    public void readService() {
        AVQuery<AVObject> query = new AVQuery<>(NEWS_CLASS_NAME);
        query.findInBackground(new FindCallback<AVObject>() {
            @Override
            public void done(List<AVObject> list, AVException e) {
                Collections.sort(list, new Comparator<AVObject>() {
                    @Override
                    public int compare(AVObject avObject, AVObject t1) {
                        int newId1 = avObject.getInt(KEY_NEWS_ID);
                        int newId2 = t1.getInt(KEY_NEWS_ID);
                        Log.d("caibingyuan", "compare newId1 = " + newId1);
                        Log.d("caibingyuan", "compare newId2 = " + newId2);

                        if (newId1 > newId2) {
                            return 1;
                        } else if(newId1 < newId2) {
                            return -1;
                        } else {
                            return 0;
                        }
                    }
                });

                for (AVObject object : list) {
                    Log.d("caibingyuan", "News Title = " + object.getString(KEY_NEWS_TITLE));
                    Log.d("caibingyuan", "News Content = " + object.get(KEY_NEWS_CONTENT));
                }
            }
        });
    }

    private void writeService() {
    }

}
