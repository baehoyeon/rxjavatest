package com.qoo.rxjavatest.basic;

import io.reactivex.Flowable;

/**
 * Created by Qoo
 * Date : 2021/03/07.
 */
public class FlowableTimeSample {
    public static void main(String[] args) {
        Flowable<Long> flowable = Flowable.just(System.currentTimeMillis());
        Flowable<Long> flowableWithFunction = Flowable.fromCallable(() -> System.currentTimeMillis());

        flowable.subscribe(System.out::println);
        flowableWithFunction.subscribe(System.out::println);
    }
}
