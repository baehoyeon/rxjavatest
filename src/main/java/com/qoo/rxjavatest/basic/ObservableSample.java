package com.qoo.rxjavatest.basic;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Qoo
 * Date : 2021/03/21.
 */
public class ObservableSample {
    public static void main(String[] args) throws InterruptedException {
        Observable<String> observable = Observable.create(emitter -> {
            String[] datas = {"Hello World!", "안녕", "Hello RxJava"};

            for (String data : datas) {
                if (emitter.isDisposed()) {
                    return;
                }

                emitter.onNext(data);
            }

            emitter.onComplete();
        });

        observable.observeOn(Schedulers.computation())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable disposable) {
                    }

                    @Override
                    public void onNext(String s) {
                        String threadName = Thread.currentThread().getName();
                        System.out.println(String.format("ThreadName : %s, data : %s", threadName, s));
                    }

                    @Override
                    public void onError(Throwable t) {
                        String threadName = Thread.currentThread().getName();
                        System.out.println(String.format("ThreadName : %s 에러 ! ", threadName));
                        t.printStackTrace();
                    }

                    @Override
                    public void onComplete() {
                        String threadName = Thread.currentThread().getName();
                        System.out.println(String.format("ThreadName : %s 완료 ! ", threadName));
                    }
                });


        Thread.sleep(5000L);
    }
}
