package com.zzs.lock;


import java.util.concurrent.TimeUnit;

/**
 * 死锁：两个或以上进程在执行中，争夺资源造成相互等待现象。
 *
 */
public class DeadLockDemo {
    public static void main(String[] args) {
        String lockA ="lockA";
        String lockB ="lockB";

        new Thread(new MyThread(lockA,lockB),"AAAA").start();
        new Thread(new MyThread(lockB,lockA),"BBBB").start();



    }
}

class MyThread implements Runnable
{
    private String lock1;
    private String lock2;

    public MyThread(String lockA, String lockB) {
        this.lock1 = lockA;
        this.lock2 = lockB;
    }

    @Override
    public void run() {
        synchronized (this.lock1)
        {
            System.out.println(Thread.currentThread().getName() + "\t -------自己持有锁：" + lock1 + "\t 尝试获得：" + lock2);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (this.lock2)
            {
                System.out.println(Thread.currentThread().getName() + "\t 自己持有锁：" + lock2 + "\t 尝试获得：" + lock1);
            }
        }
    }
}