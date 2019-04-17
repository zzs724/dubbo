package com.zzs.thread;

import java.util.concurrent.*;

/**
 * Callable带返回值的线程接口
 * 多线程下，利用一个futureTask调用实现Callable的线程，会复用。只会调一遍
 * 创建多个FutureTask<Integer> futureTask = new FutureTask<Integer>(new MyThread());则会避免复用
 */
public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask<Integer> futureTask = new FutureTask<Integer>(new MyThread());
        FutureTask<Integer> futureTask2 = new FutureTask<Integer>(new MyThread());
        new Thread(futureTask,"AA").start();
        new Thread(futureTask2,"BB").start();

        System.out.println(Thread.currentThread().getName()+"**********");
/*        while (!futureTask.isDone()) {

        }*/
        int result = futureTask.get();//get尽量放在最后否则可能会阻塞后续线程
        System.out.println(result);

    }
}
class MyThread implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName()+"************");
        TimeUnit.SECONDS.sleep(2);
        return 955;
    }
}