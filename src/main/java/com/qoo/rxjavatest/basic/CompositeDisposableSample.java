package com.qoo.rxjavatest.basic;

import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Qoo
 * Date : 2021/03/21.
 */
public class CompositeDisposableSample {
    public static void main(String[] args) throws InterruptedException {
        CompositeDisposable compositeDisposable = new CompositeDisposable();

        compositeDisposable.add(Flowable.range(1, 5)
                .doOnCancel(() -> System.out.println("1 canceled"))
                .observeOn(Schedulers.computation())
                .subscribe(data -> {
                    Thread.sleep(100);
                    System.out.println("1 :" + data);
                }));

        compositeDisposable.add(Flowable.range(1, 5)
                .doOnCancel(() -> System.out.println("2 canceled"))
                .observeOn(Schedulers.computation())
                .subscribe(data -> {
                    Thread.sleep(200);
                    System.out.println("2 :" + data);
                }));

        Thread.sleep(300L);
        compositeDisposable.dispose();
    }
}
