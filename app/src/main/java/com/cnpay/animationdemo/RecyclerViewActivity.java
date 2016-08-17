package com.cnpay.animationdemo;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import adapter.PictureAdapter;
import bean.Picture;

/**
 * 包   名:     com.cnpay.animationdemo
 * 版权所有:     版权所有(C)2010-2016
 * 公   司:     深圳华夏通宝信息技术有限公司
 * 版   本:          V1.0
 * 时   间:     2016/8/16 0016 17:09
 * 作   者:     zenghonghua
 */
public class RecyclerViewActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<Picture> mPictures;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rc);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        toolbar.setTitle("RecyclerView共享元素");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        //造数据
        mPictures = new ArrayList<>();
        for (int i = 0; i < Config.IMAGES.length; i++) {
            Picture picture = new Picture();
            String image = Config.IMAGES[i];
            picture.setUrl(image);
            mPictures.add(picture);
        }

        initData();
    }

    private void initData() {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.addItemDecoration(new RecycleViewDivider(this,LinearLayoutManager.VERTICAL));
        PictureAdapter adapter = new PictureAdapter(this, mPictures);

        mRecyclerView.setAdapter(adapter);


        adapter.setItemClickListener(new PictureAdapter.ItemClickListener() {
            @Override
            public void itemClick(View view, int position) {
                Picture picture = mPictures.get(position);
                String url = picture.getUrl();
                ImageView imageView = (ImageView) view.findViewById(R.id.item_picture);
                Intent intent = new Intent(RecyclerViewActivity.this, PictureDetailActivity.class);
                intent.putExtra("url", url);
//                Bundle bundle = ActivityOptions.makeSceneTransitionAnimation(RecyclerViewActivity.this, Pair.create(view, "pic")).toBundle();
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(RecyclerViewActivity.this, imageView, "pic");
                startActivity(intent, options.toBundle());
            }
        });
    }
}
