package com.qoo.rxjavatest.basic;

import io.reactivex.Maybe;
import io.reactivex.MaybeEmitter;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * Created by Qoo
 * Date : 2021/03/21.
 */
public class MaybeSample {
    public static void main(String[] args) {
        Maybe<DayOfWeek> maybe = Maybe.create(emitter -> {
            emitter.onSuccess(LocalDate.now().getDayOfWeek());
        });
        maybe.subscribe(new MaybeObserver<DayOfWeek>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onSuccess(DayOfWeek dayOfWeek) {
                System.out.println(dayOfWeek);
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("1 : ERROR : " + e);
            }

            @Override
            public void onComplete() {
                System.out.println("1 : Complete");
            }
        });

        Maybe<DayOfWeek> maybe2 = Maybe.create(MaybeEmitter::onComplete);
        maybe2.subscribe(new MaybeObserver<DayOfWeek>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onSuccess(DayOfWeek dayOfWeek) {
                System.out.println(dayOfWeek);
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("1 : ERROR : " + e);
            }

            @Override
            public void onComplete() {
                System.out.println("2 : Complete");
            }
        });
    }
}
