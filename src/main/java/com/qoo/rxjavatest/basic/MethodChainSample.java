package com.qoo.rxjavatest.basic;

import io.reactivex.Flowable;

/**
 * Created by Qoo
 * Date : 2021/03/07.
 */
public class MethodChainSample {
    public static void main(String[] args) {
        Flowable<Integer> flowable = Flowable.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .filter(it -> it % 2 == 0)
                .map(it -> it * 100);

        flowable.subscribe(System.out::println);
    }
}
