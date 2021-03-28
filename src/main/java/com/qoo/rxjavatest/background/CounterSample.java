package com.qoo.rxjavatest.background;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by Qoo
 * Date : 2021/03/28.
 */
@Slf4j
public class CounterSample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        final Counter counter = new Counter();
        Runnable task = () -> {
            for (int i = 0; i < 10000; i++) {
                counter.increase();
            }
        };

        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<Boolean> future1 = executorService.submit(task, true);
        Future<Boolean> future2 = executorService.submit(task, true);

        if(future1.get() && future2.get()) {
           log.info("완료 count : {}", counter.get());
        } else {
            log.error("실패");
        }

        executorService.shutdown();
    }

    static class Counter {
        private volatile int count;

        void increase() {
            this.count += 1;
        }

        int get() {
            return this.count;
        }
    }
}
