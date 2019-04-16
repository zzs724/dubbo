package com.zzs.block;

import java.util.concurrent.CountDownLatch;

/**
 * countDownLatch :倒计数
 * 使一个线程等待其他线程完成各自的工作后再执行
 */
public class CountDownLatchDemo
{
    public static void main(String[] args) throws Exception {

        final CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 1; i <= 6; i++)
        {
            new Thread(new Runnable()
            {
                public void run() {
                    System.out.println(Thread.currentThread().getName()+"\t国，被灭");
                    countDownLatch.countDown();
                }
            },CountryEnum.forEach_CountryEnum(i).getRetMessage()).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"\t秦灭六国，一统华夏");
    }

    private static void closeDoor() throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 1; i <= 6; i++)
        {
            new Thread(new Runnable()
            {
                public void run() {
                    System.out.println(Thread.currentThread().getName()+"\t上完晚自习，离开教室");
                    countDownLatch.countDown();
                }
            },String.valueOf(i)).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"\t********班长关门走人");
    }
}
