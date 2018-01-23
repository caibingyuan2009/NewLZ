package com.news.lz.adapter.holder;

import android.view.View;
import android.view.ViewGroup;

import com.news.lz.R;
import com.news.lz.entity.model.BaseItem;
import com.news.lz.entity.model.VideoItem;

import butterknife.BindView;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

/**
 * Created by caibingyuan on 2018/1/15.
 */

public class VideoViewHolder extends BaseViewHolder {
    public JCVideoPlayer mVideoPlayer;

    public VideoViewHolder(ViewGroup parentView) {
        super(parentView, R.layout.item_video_view);
    }

    @Override
    protected void initViews() {
        mVideoPlayer = (JCVideoPlayer) findViewById(R.id.video_player);
    }

    @Override
    public void updateViews(BaseItem item) {
        if (!(item instanceof VideoItem)) {
            return;
        }

        VideoItem videoItem = (VideoItem) item;

        mVideoPlayer.setUp(videoItem.getVideoUrl(), videoItem.getVideoCoverUrl(), videoItem.getVideoTitle());
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onResume() {
        mVideoPlayer.releaseAllVideos();
    }
}
