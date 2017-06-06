package com.cnpay.animationdemo;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.Toolbar;
import android.transition.Fade;
import android.view.View;
import android.view.Window;

/**
 * Created by zenghonghua on 2016/5/16 0016.
 */
public class AnimationActivity extends BaseActivity {

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
//        setSupportActionBar(toolbar);
//        ActionBar actionBar = getSupportActionBar();
//        actionBar.setDisplayHomeAsUpEnabled(true);

        CollapsingToolbarLayout mCollapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapse);

        mCollapsingToolbarLayout.setTitleEnabled(true);
        mCollapsingToolbarLayout.setTitle("CollapsingToolbarLayout");
        //通过CollapsingToolbarLayout修改字体颜色
        mCollapsingToolbarLayout.setExpandedTitleColor(Color.WHITE);//设置还没收缩时状态下字体颜色
        mCollapsingToolbarLayout.setCollapsedTitleTextColor(Color.GREEN);//设置收缩后Toolbar上字体的颜色

        toolbar.setNavigationIcon(R.mipmap.ic_back);
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
    }
}
