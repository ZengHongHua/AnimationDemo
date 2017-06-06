package com.cnpay.animationdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Explode;
import android.transition.Fade;
import android.view.Window;

/**
 * 包   名:     com.cnpay.animationdemo
 * 时   间:     2017/6/6 0006 15:12
 * 作   者:     zenghonghua
 */
public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        super.onCreate(savedInstanceState);
        getWindow().setEnterTransition(new Fade());
        getWindow().setExitTransition(new Explode());
    }
}
