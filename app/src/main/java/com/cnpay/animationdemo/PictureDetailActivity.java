package com.cnpay.animationdemo;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.Fade;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * 包   名:     com.cnpay.animationdemo
 * 版权所有:     版权所有(C)2010-2016
 * 公   司:     深圳华夏通宝信息技术有限公司
 * 版   本:          V1.0
 * 时   间:     2016/8/16 0016 18:24
 * 作   者:     zenghonghua
 */
public class PictureDetailActivity extends AppCompatActivity {

    private ImageView pic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
            getWindow().setEnterTransition(new Fade());
            getWindow().setExitTransition(null);
        }
        setContentView(R.layout.activity_animation);

        Toolbar toolbar = (Toolbar) findViewById(R.id.second_toolbar);
        pic = (ImageView) findViewById(R.id.detail_pic);

        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("图片详情");

        //返回
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= 21) {
                    finishAfterTransition();
                } else {
                    finish();
                }
            }
        });

        initPicture();
    }

    private void initPicture() {
        String url = getIntent().getStringExtra("url");
//        Log.i("URL:",url);
        Glide.with(this)
                .load(url)
                .into(pic);
    }
}
