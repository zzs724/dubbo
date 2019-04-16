package com.zzs;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 与CountDownLatch相反，相加，
 * 其他线程都执行到当前点，才会执行后续的
 * 栅栏类似于闭锁，它能阻塞一组线程直到某个事件的发生。
 * 栅栏与闭锁的关键区别在于，所有的线程必须同时到达栅栏位置，才能继续执行。
 * 闭锁用于等待事件，而栅栏用于等待其他线程。
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,() -> {
            System.out.println("***召唤神龙");
        });
        for (int i = 1; i <= 7; i++) {
            final int t = i;
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName()+"\t 收集到第："+t+"颗龙珠");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }
    }
}
