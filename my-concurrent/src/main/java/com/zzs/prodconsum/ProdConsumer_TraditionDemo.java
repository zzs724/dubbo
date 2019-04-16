package com.zzs.prodconsum;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 传统生产者消费者
 * 一个初始值0的变量，两个线程交替操作一个加一个减
 */
public class ProdConsumer_TraditionDemo {

    public static void main(String[] args)
    {
        ShareData shareData = new ShareData();

        new Thread(() -> {
            for (int i = 0; i < 5; i++)
            {
                try {
                    shareData.add();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"AAA").start();

        new Thread(() -> {
            for (int i = 0; i < 5; i++)
            {
                try {
                    shareData.de();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"BBB").start();

    }


}

class ShareData//资源类
{
    private int num = 0;

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    //多线程防止虚假唤醒，判断要用while不能用if
    public void add() throws Exception {
        lock.lock();
        try {
            while (num == 0) {
                //2.生产
                num++;
                System.out.println(Thread.currentThread().getName() + "\t 生产" + num);
                //3.通知消费
                condition.signal();

            }
            //1.等待消费不能生产
            condition.await();
        } finally {
            lock.unlock();
        }
    }

    public void de() throws Exception {
        lock.lock();
        try {
            while (num == 0) {
                //1.等待不能消费
                condition.await();
            }
            //2.消费
            num--;
            System.out.println(Thread.currentThread().getName() + "\t 消费" + num);
            //3.通知生产
            condition.signal();
        } finally {
            lock.unlock();
        }
    }

}
