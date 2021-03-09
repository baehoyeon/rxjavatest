package com.qoo.rxjavatest.basic;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

/**
 * Created by Qoo
 * Date : 2021/03/09.
 */
public class ObservableFlowableDiff {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("######## Observable");
        Observable.range(1, 300) // 여기만 차이
                .doOnEach(i -> System.out.println("start: " + i))
                .observeOn(Schedulers.io())
                .subscribe(i -> {
                    System.out.println("end: " + i);
                    TimeUnit.MILLISECONDS.sleep(10);
                });
        TimeUnit.SECONDS.sleep(10);

        System.out.println("######## Flowable");
        Flowable.range(1, 300) // 여기만 차이
                .doOnEach(i -> System.out.println("start: " + i))
                .observeOn(Schedulers.io())
                .subscribe(i -> {
                    System.out.println("end: " + i);
                    TimeUnit.MILLISECONDS.sleep(10);
                });
        TimeUnit.SECONDS.sleep(10);
    }
}
