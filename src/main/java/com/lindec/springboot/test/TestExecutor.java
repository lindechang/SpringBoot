package com.lindec.springboot.test;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by lindec on 2016/3/21.
 */
public class TestExecutor {

    static Executor executor = Executors.newWorkStealingPool();

//    public static void main(String[] arg0) {
//
//
//        for (int i = 0; i < 10; i++) {
//            test(i);
//        }
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//    }

    public static void test(int i) {
        executor.execute(() -> System.out.println("---------------i=" + i + "-------------:" + Thread.currentThread().toString()));
    }
}
