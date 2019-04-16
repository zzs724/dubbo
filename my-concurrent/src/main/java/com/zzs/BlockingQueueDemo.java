package com.zzs;

import jdk.nashorn.internal.ir.Block;
import sun.security.provider.NativePRNG;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.*;

/**
 * ArrayBlockingQueue：一个基于数组结构的有界阻塞队列，此队列安FIFO先进先出原则对原始排序
 * LinkedBlockingQueue：一个基于链表结构，此队列安FIFO先进先出原则对原始排序，吞吐量高于ArrayBlockingQueue
 * SynchronousQueue：不存储元素的阻塞队列，每个插入操作必须等到另一个线程调用移除操作，否则插入一直处于阻塞，
 *
 * 阻塞队列：当队列为空时，获取队列元素时线程会被阻塞
 *            当队里满时，添加元素会被阻塞
 * 阻塞队列会管理线程何时需阻塞，何时需被唤醒
 *
 */
public class BlockingQueueDemo
{

    public static void main(String[] args) throws InterruptedException {
        //ArrayBlockingQueue:数组结构组成的有界阻塞队列。有初始值
        //LinkedBlockingQueue：链表结构有界（大小默认Integer.MAX_VALUE 21亿类似于无界），太大了
        //SynchronousQueue：不存储元素的阻塞队列，每个插入操作必须等到另
        // 一个线程调用移除操作，否则插入一直处于阻塞。队列只有一个元素
        BlockingQueue<String> blockingQueue = new SynchronousQueue<>();//同步队列
        new Thread(()->{
            try
            {
                System.out.println(Thread.currentThread().getName()+"\t put 1");
                blockingQueue.put("1");
                System.out.println(Thread.currentThread().getName()+"\t put 2");
                blockingQueue.put("2");
                System.out.println(Thread.currentThread().getName()+"\t put 3");
                blockingQueue.put("3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"AAA").start();

        new Thread(()->{
            try
            {
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName()+"\t "+blockingQueue.take());
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName()+"\t "+blockingQueue.take());
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName()+"\t "+blockingQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"BBB").start();

    }

    private static void timeout() throws InterruptedException {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(1);

        System.out.println(blockingQueue.offer("a", 2, TimeUnit.SECONDS));
//        System.out.println(blockingQueue.offer("b", 2, TimeUnit.SECONDS));当队列满时，只会阻塞设定时间2秒，返回false
    }

    private static void block() throws InterruptedException {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(1);
        blockingQueue.put("a");//无返回值
//        blockingQueue.put("b");队列满了继续添加元素会线程会阻塞
        blockingQueue.take();//无返回值
//        blockingQueue.take();队列为空删除 线程会阻塞
    }

    private static void teshuzhi() {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(3);
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
//        System.out.println(blockingQueue.offer("d"));队列满了返回false

        System.out.println(blockingQueue.peek());//检查队列元素，有则返回队列首元素，无则返回null

        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
//        System.out.println(blockingQueue.poll());队列空了继续删除返回null
    }

    private static void addAndRemove() {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(3);
        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));
//        System.out.println(blockingQueue.add("e"));队列满了会报错Queue full
        System.out.println(blockingQueue.element());//检查队列是否为空，不为空返回队首元素


        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
//        System.out.println(blockingQueue.remove());队列为空时报错NoSuchElementException
    }


}
