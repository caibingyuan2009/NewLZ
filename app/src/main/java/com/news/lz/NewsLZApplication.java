package com.news.lz;

import android.app.Application;
import android.content.Context;

import com.avos.avoscloud.AVOSCloud;

/**
 * Created by caibingyuan on 2018/1/11.
 */

public class NewsLZApplication extends Application {
    private static final String APPLICATION_ID = "5uCeQhsdkbegTHiAeEkBWmiB-gzGzoHsz";
    private static final String APPLICATION_KEY = "cA31fdAqyaPtmO4H4Lirhk4P";

    private static Context sContext;

    public static Context getAppContext() {
        // 全局的Context
        return sContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = this;

        initMainProcess();
    }

    private void initMainProcess() {
        initLeanCloudSdk();
    }

    private void initLeanCloudSdk() {
        // 初始化参数依次为 this, AppId, AppKey
        AVOSCloud.initialize(this, APPLICATION_ID, APPLICATION_KEY);
        AVOSCloud.setDebugLogEnabled(true);
    }

}
