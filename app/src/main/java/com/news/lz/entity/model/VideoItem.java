package com.news.lz.entity.model;

/**
 * Created by caibingyuan on 2018/1/15.
 */

public class VideoItem extends BaseItem {
    private String mVideoTitle;
    private String mVideoCoverUrl;
    private String mVideoUrl;

    public String getVideoTitle() {
        return mVideoTitle;
    }

    public void setVideoTitle(String videoTitle) {
        mVideoTitle = videoTitle;
    }

    public String getVideoCoverUrl() {
        return mVideoCoverUrl;
    }

    public void setVideoCoverUrl(String videoCoverUrl) {
        mVideoCoverUrl = videoCoverUrl;
    }

    public String getVideoUrl() {
        return mVideoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        mVideoUrl = videoUrl;
    }
}
