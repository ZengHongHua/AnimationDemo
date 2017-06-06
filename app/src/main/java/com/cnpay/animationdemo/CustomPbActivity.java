package com.cnpay.animationdemo;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

/**
 * 自定义直线进度条
 * 包   名:     com.cnpay.animationdemo
 * 时   间:     2017/3/2 0002 10:06
 * 作   者:     zenghonghua
 */
public class CustomPbActivity extends BaseActivity {

    private ProgressBar pb;
    private Button btn_dialog;
    private int progress = 0;

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            pb.setProgress(progress);
        }
    };
    private MyThread mMyThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custompb);

        pb = (ProgressBar) findViewById(R.id.custom_pb);
        btn_dialog = (Button) findViewById(R.id.custom_btn_dialog);

        mMyThread = new MyThread();
        mMyThread.start();

        btn_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });
    }

    private void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Material Dialog");
        builder.setMessage("5.0以上新Dialog");

        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setNegativeButton("取消", null);
        builder.setItems(new String[]{"item","item"},null);
        builder.show();
    }

    class MyThread extends Thread {
        @Override
        public void run() {
            super.run();
            while (!Thread.interrupted()) {
                try {
                    Thread.sleep(50);
                    progress += 2;
                    if(progress > 100) {
                        progress = 0;
                    }
                    mHandler.sendEmptyMessage(0);
                } catch (Exception e) {
                    e.printStackTrace();
                    Thread.interrupted();
                }
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMyThread.interrupt();
    }
}
