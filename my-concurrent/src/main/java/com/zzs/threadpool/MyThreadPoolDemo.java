package com.zzs.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class MyThreadPoolDemo {
    public static void main(String[] args) {
        //线程池中有5个线程
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        //线程池中有1个线程
        ExecutorService threadPool2 = Executors.newSingleThreadExecutor();

        //线程池中有n个线程:根据情况，需要几个就有几个
        ExecutorService threadPool3 = Executors.newCachedThreadPool();
        try {
            for (int i = 0; i < 10; i++) {
                threadPool3.execute(() ->{
                    System.out.println(Thread.currentThread().getName()+"\t 办理业务");
                });
            }
        } catch (Exception e) {

        } finally {
            threadPool3.shutdown();
        }


    }
}
