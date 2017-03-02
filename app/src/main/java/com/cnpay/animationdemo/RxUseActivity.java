package com.cnpay.animationdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * 包   名:     com.cnpay.animationdemo
 * 时   间:     2017/2/22 0022 15:32
 * 作   者:     zenghonghua
 */
public class RxUseActivity extends AppCompatActivity {

    private TextView tv_one;
    private Button btn_fashe;
    private Observable<Integer> mObservable;
    private Observer<Integer> mObserver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_use_rx);
        //Observable    被观察者    observable,被观察者
        //Observer  观察者 observer    观察者
        //Subscribe 订阅  subscribe   subscribe   订阅
        //Consumer  消费者
        btn_fashe = (Button) findViewById(R.id.btn_fashe);
        tv_one = (TextView) findViewById(R.id.tv_one);

        mObservable = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
                e.onNext(2);
                e.onNext(3);
                e.onComplete();

            }
        });


        //观察者
        mObserver = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.i("RxUseActivity", "RxUseActivity");
            }

            @Override
            public void onNext(Integer integer) {
                Log.i("RxUseActivity",integer+"");
                tv_one.setText("收到消息"+integer);
            }

            @Override
            public void onError(Throwable e) {
                Log.i("RxUseActivity",e.getMessage());
            }

            @Override
            public void onComplete() {
                Log.i("RxUseActivity","onComplete");
            }
        };

        Consumer<Integer> consumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {

            }
        };

        //Schedulers.io() 代表io操作的线程, 通常用于网络,读写文件等io密集型的操作
        //Schedulers.computation() 代表CPU计算密集型的操作, 例如需要大量计算的操作
        //Schedulers.newThread() 代表一个常规的新线程
        //AndroidSchedulers.mainThread() 代表Android的主线程
        mObservable.subscribeOn(Schedulers.newThread()) //  subscribeOn 发送在子线程
                .observeOn(AndroidSchedulers.mainThread())  //observeOn 接收在android主线程
                .subscribe(consumer);


    }


}
