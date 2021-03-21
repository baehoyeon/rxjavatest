package com.qoo.rxjavatest.basic;

import io.reactivex.Flowable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/**
 * Created by Qoo
 * Date : 2021/03/21.
 */
public class RequestMethodSample {
    public static void main(String[] args) {
        Flowable.just(1, 2, 3)
                .subscribe(new Subscriber<Integer>() {
                    @Override
                    public void onSubscribe(Subscription s) {
                        System.out.println("onSubscribe start");
                        s.request(Long.MAX_VALUE);
                        System.out.println("onSubscribe end");
                    }

                    @Override
                    public void onNext(Integer integer) {
                        System.out.println(integer);
                    }

                    @Override
                    public void onError(Throwable t) {
                        System.out.println("ERROR : " + t);
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("Completed");
                    }
                });
    }
}
