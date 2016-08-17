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

/**
 * Created by zenghonghua on 2016/5/16 0016.
 */
public class AnimationActivity extends AppCompatActivity {

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
        actionBar.setTitle("美女图");

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
