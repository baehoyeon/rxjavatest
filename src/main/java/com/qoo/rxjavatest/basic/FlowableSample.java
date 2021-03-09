package com.qoo.rxjavatest.basic;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/**
 * Created by Qoo
 * Date : 2021/03/09.
 */
public class FlowableSample {
    public static void main(String[] args) throws InterruptedException {
        Flowable<String> flowable = Flowable.create(emitter -> {
            String[] datas = {"Hello World!", "안녕", "Hello RxJava"};

            for (String data : datas) {
                if (emitter.isCancelled()) {
                    return;
                }

                emitter.onNext(data);
            }

            emitter.onComplete();
        }, BackpressureStrategy.BUFFER);

        flowable.observeOn(Schedulers.computation())
                .subscribe(new Subscriber<String>() {

                    private Subscription subscription;

                    @Override
                    public void onSubscribe(Subscription s) {
                        this.subscription = s;
                        this.subscription.request(1L);
                    }

                    @Override
                    public void onNext(String s) {
                        String threadName = Thread.currentThread().getName();
                        System.out.println(String.format("ThreadName : %s, data : %s", threadName, s));
                        this.subscription.request(1L);
                    }

                    @Override
                    public void onError(Throwable t) {
                        String threadName = Thread.currentThread().getName();
                        System.out.println(String.format("ThreadName : %s 에러 ! ", threadName));
                        t.printStackTrace();
                    }

                    @Override
                    public void onComplete() {
                        String threadName = Thread.currentThread().getName();
                        System.out.println(String.format("ThreadName : %s 완료 ! ", threadName));
                    }
                });


        Thread.sleep(5000L);
    }
}
