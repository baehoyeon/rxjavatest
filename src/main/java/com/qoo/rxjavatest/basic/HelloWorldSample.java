package com.qoo.rxjavatest.basic;

import io.reactivex.Flowable;

/**
 * Created by Qoo
 * Date : 2021/03/06.
 */
public class HelloWorldSample {
    public static void main(String[] args) {
        Flowable<String> flowable = Flowable.just("Hello", "World");
        flowable.subscribe(System.out::println);
    }
}
