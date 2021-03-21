package com.qoo.rxjavatest.basic;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * Created by Qoo
 * Date : 2021/03/21.
 */
public class CompletableSample {
    public static void main(String[] args) {
        Completable completable = Completable.create(emitter -> {
            System.out.println("process something");
            emitter.onComplete();
        });

        completable.subscribe(new CompletableObserver() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onComplete() {
                System.out.println("Completed");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("ERROR : " + e);
            }
        });
    }
}
