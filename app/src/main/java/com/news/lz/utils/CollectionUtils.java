package com.news.lz.utils;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by caibingyuan on 2017/12/27.
 */

public class CollectionUtils {

    public static boolean isMapEmpty(Map map) {
        return map == null || map.size() <= 0;
    }

    public static boolean isListEmpty(List list) {
        return list == null || list.size() <= 0;
    }

    public static boolean isSetEmpty(Set set) {
        return set == null || set.size() <= 0;
    }

}
