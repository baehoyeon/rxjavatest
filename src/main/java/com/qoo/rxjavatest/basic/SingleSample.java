package com.qoo.rxjavatest.basic;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * Created by Qoo
 * Date : 2021/03/21.
 */
public class SingleSample {
    public static void main(String[] args) {
        Single<DayOfWeek> single = Single.create(emitter -> {
            emitter.onSuccess(LocalDate.now().getDayOfWeek());
        });

        single.subscribe(new SingleObserver<DayOfWeek>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onSuccess(DayOfWeek dayOfWeek) {
                System.out.println(dayOfWeek);
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("ERROR : " + e);
            }
        });
    }
}
