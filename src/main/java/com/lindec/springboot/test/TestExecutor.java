package com.lindec.springboot.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * Created by lindec on 2016/3/21.
 */
public class TestExecutor {

    static Executor executor = Executors.newFixedThreadPool(5);

    static Executor executor1 = Executors.newWorkStealingPool();
    static ExecutorService executor2 = Executors.newWorkStealingPool();

    static AtomicInteger atomicInteger = new AtomicInteger();

    public static void main(String[] arg0) {

//        System.out.println("--------:" + executor.toString());

//        for (int i = 0; i < 10; i++) {
//            test(i);
//
//        }

        IntStream.range(0, 10).forEach(j -> {
            List<Callable<Object>> list = new ArrayList<>();
            IntStream.range(0, 10).forEach(i -> list.add(Executors.callable(new Task())));
            try {
                List<Future<Object>> rusult = executor2.invokeAll(list);
                rusult.forEach(f -> System.out.println("------------f:" + f.isDone()));
            } catch (Exception e) {
                e.printStackTrace();
            }

        });


//            try {
//                Thread.sleep(5000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }


    }

    public static void test(int i) {
        executor.execute(() -> System.out.println("---------------i=" + i + "-------------:" + Thread.currentThread().toString()));
    }

    public static class Task implements Runnable {

        @Override
        public void run() {
            int ii = atomicInteger.addAndGet(1);
            if (ii % 10 == 0) {
                //System.out.println("Executor Done!!!");
                System.out.println("---------------i=" + ii + "-------------:" + Thread.currentThread().toString());
            } else {
                System.out.println("---------------ii=" + ii + "-------------:" + Thread.currentThread().toString());
            }
        }
    }
}
