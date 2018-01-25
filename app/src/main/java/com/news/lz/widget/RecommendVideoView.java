package com.news.lz.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.news.lz.R;
import com.news.lz.entity.model.BaseItem;
import com.news.lz.entity.model.VideoItem;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

import static fm.jiecao.jcvideoplayer_lib.JCVideoPlayer.CURRENT_STATE_PLAYING;

/**
 * Created by caibingyuan on 2018/1/25.
 */

public class RecommendVideoView extends FrameLayout {
    public JCVideoPlayer mVideoPlayer;
    public VideoItem mVideoItem;

    public RecommendVideoView(@NonNull Context context) {
        this(context, null);
    }

    public RecommendVideoView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RecommendVideoView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initViews();
    }

    private void initViews() {
        View rootView = LayoutInflater.from(getContext()).inflate(R.layout.item_video_view, this);
        mVideoPlayer = (JCVideoPlayer) rootView.findViewById(R.id.video_player);
    }

    public void updateViews(BaseItem baseItem) {
        if (!(baseItem instanceof VideoItem)) {
            return;
        }

        mVideoItem = (VideoItem) baseItem;

        mVideoPlayer.setUp(mVideoItem.getVideoUrl(), mVideoItem.getVideoCoverUrl(), mVideoItem.getVideoTitle());
    }

    public void stopVideo() {
        mVideoPlayer.pauseVideo();
    }

    public void releaseVideo() {
        mVideoPlayer.release();
    }

    public void restartVideo() {
        if (mVideoPlayer == null) {
            return;
        }
        mVideoPlayer.playVideo();
    }
}
