package com.zzs;

import java.util.concurrent.Semaphore;

/**
 * 信号量：1、用于多个共享资源的互斥使用
 *          2、用于并发线程数控制
 *   public Semaphore(int permits);//permits就是允许同时运行的线程数目
 *   默认非公平锁
 *   public Semaphore(int permits,boolean fair) fair：是否公平
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);//3个车位
        for (int i = 1; i <= 6; i++)//6个车
        {
            new Thread(() ->{
                try {
                    semaphore.acquire();//该线程抢到资源
                    System.out.println(Thread.currentThread().getName()+"\t抢到车位");
                    Thread.sleep(3000);
                    System.out.println(Thread.currentThread().getName()+"\t3秒后离开车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }
            },String.valueOf(i)).start();
        }
    }
}
