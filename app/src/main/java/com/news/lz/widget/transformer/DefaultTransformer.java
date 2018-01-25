package com.news.lz.widget.transformer;

import android.support.v4.view.ViewPager;
import android.view.View;

import com.news.lz.widget.CustomViewPager;

/**
 * Created by caibingyuan on 2018/1/24.
 */

public class DefaultTransformer implements CustomViewPager.PageTransformer {

    @Override
    public void transformPage(View view, float position) {
        float alpha = 0;
        if (0 <= position && position <= 1) {
            alpha = 1 - position;
        } else if (-1 < position && position < 0) {
            alpha = position + 1;
        }
        view.setAlpha(alpha);
        view.setTranslationX(view.getWidth() * -position);
        float yPosition = position * view.getHeight();
        view.setTranslationY(yPosition);
    }
}
