package com.news.lz.entity;

/**
 * Created by caibingyuan on 2018/1/12.
 * 新闻数据类
 */

public class NewItem {
    private int mNewId;
    private String mNewTitle;
    private String mNewContent;
    private String mNewPicUrl;

    public int getNewId() {
        return mNewId;
    }

    public void setNewId(int newId) {
        mNewId = newId;
    }

    public String getNewTitle() {
        return mNewTitle;
    }

    public void setNewTitle(String newTitle) {
        mNewTitle = newTitle;
    }

    public String getNewContent() {
        return mNewContent;
    }

    public void setNewContent(String newContent) {
        mNewContent = newContent;
    }

    public void setNewPicUrl(String newPicUrl) {
        mNewPicUrl = newPicUrl;
    }

    public String getNewPicUrl() {
        return mNewPicUrl;
    }
}
