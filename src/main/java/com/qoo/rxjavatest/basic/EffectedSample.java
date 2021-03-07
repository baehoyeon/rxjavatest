package com.qoo.rxjavatest.basic;

import io.reactivex.Flowable;

import java.util.concurrent.TimeUnit;

/**
 * Created by Qoo
 * Date : 2021/03/07.
 */
public class EffectedSample {
    private static State calcMethod;

    public static void main(String[] args) throws InterruptedException {
        calcMethod = State.ADD;

        Flowable<Long> flowable = Flowable.interval(300L, TimeUnit.MILLISECONDS)
                .take(7)
                .scan((sum, data) -> {
                    if (calcMethod == State.ADD) {
                        return sum + data;
                    }

                    return sum * data;
                });

        flowable.subscribe(data -> System.out.println("data = "+ data));

        Thread.sleep(1000);
        System.out.println("change to MULTIPLY");
        calcMethod = State.MULTIPLY;

        Thread.sleep(2000);
    }

    private enum State {
        ADD, MULTIPLY
    }
}
