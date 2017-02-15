package com.cnpay.animationdemo;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

/**
 * 包   名:     com.cnpay.animationdemo
 * 时   间:     2017/2/9 0009 13:55
 * 作   者:     zenghonghua
 */
public class ToolbarActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar tb;
    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;
    private RelativeLayout relative;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawerlayout);

        //设置状态栏透明
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(Color.TRANSPARENT);
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        }


        tb = (Toolbar) findViewById(R.id.toolbar_tb);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mNavigationView = (NavigationView) findViewById(R.id.nav);
        //relative = (RelativeLayout) findViewById(R.id.relative);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDrawerLayout, tb, R.string.open, R.string.close);
        mDrawerLayout.setDrawerListener(toggle);
        toggle.syncState();

        mNavigationView.setNavigationItemSelectedListener(this);

        tb.setNavigationIcon(R.mipmap.navigation);
//        tb.setTitle("标题");
//        tb.setSubtitle("子标题");
        tb.setTitleTextColor(getResources().getColor(R.color.white));
        tb.setSubtitleTextColor(getResources().getColor(R.color.white));

        tb.inflateMenu(R.menu.action_menu);
        tb.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.search1) {
                    Toast.makeText(ToolbarActivity.this, "位置1", Toast.LENGTH_SHORT).show();
                }
//                else if (itemId == R.id.search1) {
//                    Toast.makeText(ToolbarActivity.this, "位置2", Toast.LENGTH_SHORT).show();
//                } else if (itemId == R.id.search1) {
//                    Toast.makeText(ToolbarActivity.this, "位置3", Toast.LENGTH_SHORT).show();
//
//                }
                return true;
            }
        });

    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
