package com.cnpay.animationdemo;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.shuyu.gsyvideoplayer.GSYPreViewManager;
import com.shuyu.gsyvideoplayer.GSYVideoPlayer;
import com.shuyu.gsyvideoplayer.listener.LockClickListener;
import com.shuyu.gsyvideoplayer.listener.StandardVideoAllCallBack;
import com.shuyu.gsyvideoplayer.utils.OrientationUtils;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;

import video.LandLayoutVideo;

/**
 * 包   名:     com.cnpay.animationdemo
 * 时   间:     2017/2/14 0014 14:18
 * 作   者:     zenghonghua
 */
public class DetailPlayerActivity extends AppCompatActivity {

    private LandLayoutVideo mVideo;
    private OrientationUtils orientationUtils;

    private boolean isPlay;
    private boolean isPause;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailplayer);

        mVideo = (LandLayoutVideo) findViewById(R.id.detail_player_video);


        String url = "https://res.cloudinary.com/liuyuesha/video/upload/v1475978853/%E5%B9%BF%E5%91%8A_bl4dbp.mp4";
        mVideo.setUp(url,true,null,null,"视频播放");

        //增加封面
        ImageView imageView = new ImageView(this);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setImageResource(R.mipmap.xxx1);
        mVideo.setThumbImageView(imageView);

        mVideo.getTitleTextView().setVisibility(View.VISIBLE);
        mVideo.getTitleTextView().setText("我的视频");
        mVideo.getBackButton().setVisibility(View.VISIBLE);
        mVideo.getBackButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        orientationUtils = new OrientationUtils(this, mVideo);
        orientationUtils.setEnable(false);
        //关闭自动旋转
        mVideo.setRotateViewAuto(false);
        mVideo.setLockLand(false);
        mVideo.setShowFullAnimation(false);
        mVideo.setNeedLockFull(true);
        mVideo.setOpenPreView(true);

        mVideo.getFullscreenButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //直接横屏
                orientationUtils.resolveByClick();

                //第一个true是否需要隐藏actionbar，第二个true是否需要隐藏statusbar
                mVideo.startWindowFullscreen(DetailPlayerActivity.this, true, true);
            }
        });

        mVideo.setStandardVideoAllCallBack(new StandardVideoAllCallBack() {
            @Override
            public void onClickStartThumb(String s, Object... objects) {

            }

            @Override
            public void onClickBlank(String s, Object... objects) {

            }

            @Override
            public void onClickBlankFullscreen(String s, Object... objects) {

            }

            @Override
            public void onPrepared(String s, Object... objects) {
//开始播放了才能旋转和全屏
                orientationUtils.setEnable(true);
                isPlay = true;
            }

            @Override
            public void onClickStartIcon(String s, Object... objects) {

            }

            @Override
            public void onClickStartError(String s, Object... objects) {

            }

            @Override
            public void onClickStop(String s, Object... objects) {

            }

            @Override
            public void onClickStopFullscreen(String s, Object... objects) {

            }

            @Override
            public void onClickResume(String s, Object... objects) {

            }

            @Override
            public void onClickResumeFullscreen(String s, Object... objects) {

            }

            @Override
            public void onClickSeekbar(String s, Object... objects) {

            }

            @Override
            public void onClickSeekbarFullscreen(String s, Object... objects) {

            }

            @Override
            public void onAutoComplete(String s, Object... objects) {

            }

            @Override
            public void onEnterFullscreen(String s, Object... objects) {

            }

            @Override
            public void onQuitFullscreen(String s, Object... objects) {
                if (orientationUtils != null) {
                    orientationUtils.backToProtVideo();
                }
            }

            @Override
            public void onQuitSmallWidget(String s, Object... objects) {

            }

            @Override
            public void onEnterSmallWidget(String s, Object... objects) {

            }

            @Override
            public void onTouchScreenSeekVolume(String s, Object... objects) {

            }

            @Override
            public void onTouchScreenSeekPosition(String s, Object... objects) {

            }

            @Override
            public void onTouchScreenSeekLight(String s, Object... objects) {

            }

            @Override
            public void onPlayError(String s, Object... objects) {

            }
        });

        mVideo.setLockClickListener(new LockClickListener() {
            @Override
            public void onClick(View view, boolean lock) {
                if (orientationUtils != null) {
                    //配合下方的onConfigurationChanged
                    orientationUtils.setEnable(!lock);
                }
            }
        });
    }

    @Override
    public void onBackPressed() {

        if (orientationUtils != null) {
            orientationUtils.backToProtVideo();
        }

        if (StandardGSYVideoPlayer.backFromWindowFull(this)) {
            return;
        }
        super.onBackPressed();
    }


    @Override
    protected void onPause() {
        super.onPause();
        isPause = true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        isPause = false;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        GSYVideoPlayer.releaseAllVideos();
        GSYPreViewManager.instance().releaseMediaPlayer();
        if (orientationUtils != null)
            orientationUtils.releaseListener();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        //如果旋转了就全屏
        if (isPlay && !isPause) {
            if (newConfig.orientation == ActivityInfo.SCREEN_ORIENTATION_USER) {
                if (!mVideo.isIfCurrentIsFullscreen()) {
                    mVideo.startWindowFullscreen(DetailPlayerActivity.this, true, true);
                }
            } else {
                //新版本isIfCurrentIsFullscreen的标志位内部提前设置了，所以不会和手动点击冲突
                if (mVideo.isIfCurrentIsFullscreen()) {
                    StandardGSYVideoPlayer.backFromWindowFull(this);
                }
                if (orientationUtils != null) {
                    orientationUtils.setEnable(true);
                }
            }
        }
    }
}
