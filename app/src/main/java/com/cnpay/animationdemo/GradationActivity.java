package com.cnpay.animationdemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;

import gradation.GradationScrollView;
import gradation.StatusBarUtil;

/**
 * 标题栏渐变
 *
 * 包   名:     com.cnpay.animationdemo
 * 版权所有:     版权所有(C)2010-2016
 * 版   本:          V1.0
 * 时   间:     2017/1/6 0006 11:37
 * 作   者:     zenghonghua
 */
public class GradationActivity extends AppCompatActivity implements GradationScrollView.ScrollViewListener {

    GradationScrollView mScrollView;
    ImageView mImageView;
    TextView mTextView; //标题
    private int mHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtil.setImgTransparent(this);
        setContentView(R.layout.activity_gradation);

        mScrollView = (GradationScrollView) findViewById(R.id.scrollView);
        mImageView = (ImageView) findViewById(R.id.imageView);
        mTextView = (TextView) findViewById(R.id.gradation_title);

        initListeners();

    }

    private void initListeners() {
        ViewTreeObserver viewTreeObserver = mImageView.getViewTreeObserver();
        viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {

                mTextView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                mHeight = mImageView.getHeight();

                mScrollView.setScrollViewListener(GradationActivity.this);
            }
        });
    }

    //滑动监听
    @Override
    public void onScrollChanged(GradationScrollView scrollView, int x, int y, int oldx, int oldy) {
        if (y <= 0) {                                                    //y轴上移或者下移  设置标题的背景颜色
            mTextView.setBackgroundColor(Color.argb((int) 0, 63,81,181));      //标题栏变成灰色

        } else if (y > 0 && y <= mHeight) { //滑动距离小于banner图的高度时，设置背景和字体颜色颜色透明度渐变
            float scale = (float) y / mHeight;
            float alpha = (255 * scale);
            mTextView.setTextColor(Color.argb((int) alpha, 255,255,255));
            mTextView.setBackgroundColor(Color.argb((int) alpha, 63,81,181));
        } else {    //滑动到banner(标题)下面设置普通颜色
            mTextView.setBackgroundColor(Color.argb((int) 255, 63,81,181));
        }
    }
}
