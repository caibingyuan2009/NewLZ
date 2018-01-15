package com.news.lz;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Environment;
import android.widget.ImageView;

import com.avos.avoscloud.AVOSCloud;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.UsingFreqLimitedMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;

import java.io.File;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

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
        initUniversalImageLoader();
        initJcVideoPlayer();
        initLeanCloudSdk();
    }

    private void initUniversalImageLoader() {
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .showImageOnLoading(new ColorDrawable(Color.parseColor("#f0f0f0")))
                .resetViewBeforeLoading(true)
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .considerExifParams(true)
                .imageScaleType(ImageScaleType.EXACTLY_STRETCHED)
                .bitmapConfig(Bitmap.Config.RGB_565)
                .build();

        int memClass = ((ActivityManager) getSystemService(Context.ACTIVITY_SERVICE))
                .getMemoryClass();
        int memCacheSize = 1024 * 1024 * memClass / 8;

        File cacheDir = new File(Environment.getExternalStorageDirectory().getPath() + "/video/cache");
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this)
                .threadPoolSize(3)
                .threadPriority(Thread.NORM_PRIORITY - 2)
                .denyCacheImageMultipleSizesInMemory()
                .diskCacheFileNameGenerator(new Md5FileNameGenerator())
                .memoryCache(new UsingFreqLimitedMemoryCache(memCacheSize))
                .memoryCacheSize(memCacheSize)
                .diskCacheSize(50 * 1024 * 1024)
                .tasksProcessingOrder(QueueProcessingType.LIFO)
                .diskCache(new UnlimitedDiskCache(cacheDir))
                .imageDownloader(new BaseImageDownloader(this, 5 * 1000, 30 * 1000))
                .defaultDisplayImageOptions(options)
                .build();
        ImageLoader.getInstance().init(config);
    }

    private void initJcVideoPlayer() {
        JCVideoPlayer.setThumbImageViewScalType(ImageView.ScaleType.FIT_XY);
    }

    private void initLeanCloudSdk() {
        // 初始化参数依次为 this, AppId, AppKey
        AVOSCloud.initialize(this, APPLICATION_ID, APPLICATION_KEY);
        AVOSCloud.setDebugLogEnabled(true);
    }

}
