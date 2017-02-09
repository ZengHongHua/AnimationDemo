package com.cnpay.animationdemo;

import android.animation.Animator;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.ChangeTransform;
import android.transition.Fade;
import android.transition.Transition;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.Window;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
            getWindow().setEnterTransition(new Fade());
        }
//        if (Build.VERSION.SDK_INT >= 21) {
//            Window window = getWindow();
//            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
//            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
//            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//            window.setStatusBarColor(Color.TRANSPARENT);
//            window.setNavigationBarColor(Color.TRANSPARENT);
//        }
        setContentView(R.layout.activity_main);

        final View mIv_yin = (ImageView) findViewById(R.id.main_iv_yindu);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.setTitle("MaterialDesign");

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        if (Build.VERSION.SDK_INT >= 21) {
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Animator animator = createAnimationTwo(v);
                    animator.start();
                    startActivity(new Intent(MainActivity.this, ToolbarActivity.class));
                }
            });
        }

        //拿枪美女图片点击
        final View iv_share = (ImageView) findViewById(R.id.main_share);
        iv_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= 21) {
                    Transition ts = new ChangeTransform();
                    ts.setDuration(3000);
                    getWindow().setExitTransition(ts);
                    Intent intent = new Intent(MainActivity.this, AnimationActivity.class);
//                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,iv_share,"pic");
                    Bundle bundle = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,
                            Pair.create(iv_share, "pic"),       //这个iv_share，还是必须是View,不然会报错，搞不懂
                            Pair.create(mIv_yin, "second")).toBundle();
                    // start the new activity
                    startActivity(intent, bundle);
                } else {
                    startActivity(new Intent(MainActivity.this, AnimationActivity.class));
                }
            }
        });

        //印度美女图片点击
        ImageView iv_yindu = (ImageView) findViewById(R.id.main_iv_yindu);
        iv_yindu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= 21) {
                    Animator animator = createAnimation(v);
                    animator.start();
                }
            }
        });

        //进入recyclerView界面
        findViewById(R.id.main_btn_share).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RecyclerViewActivity.class));
            }
        });

        findViewById(R.id.main_btn_gradation).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, GradationActivity.class));
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {

    }

    //动画
    public Animator createAnimation(View v) {
        // create a CircularReveal animation
        if (Build.VERSION.SDK_INT >= 21) {
            Animator animator = ViewAnimationUtils.createCircularReveal(
                    v,
                    0,
                    0,
                    0,
                    (float) Math.hypot(v.getWidth(), v.getHeight())
            );
            animator.setInterpolator(new AccelerateDecelerateInterpolator());
            animator.setDuration(800);
            return animator;
        }
        return null;
    }

    //圈圈动画
    public Animator createAnimationTwo(View v) {
        // create a CircularReveal animation
        if (Build.VERSION.SDK_INT >= 21) {
            Animator animator = ViewAnimationUtils.createCircularReveal(
                    v,
                    v.getWidth() / 2,
                    v.getHeight() / 2,
                    0,
                    v.getWidth()
            );
            animator.setInterpolator(new AccelerateDecelerateInterpolator());
            animator.setDuration(800);
            return animator;
        }
        return null;
    }
}
