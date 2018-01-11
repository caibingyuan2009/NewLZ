package com.news.lz.engine;

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



}
