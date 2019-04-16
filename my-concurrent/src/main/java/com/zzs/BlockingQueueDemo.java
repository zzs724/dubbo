package com.zzs;

/**
 * ArrayBlockingQueue：一个基于数组结构的有界阻塞队列，此队列安FIFO先进先出原则对原始排序
 * LinkedBlockingQueue：一个基于链表结构，此队列安FIFO先进先出原则对原始排序，吞吐量高于ArrayBlockingQueue
 * SynchronousQueue：不存储元素的阻塞队列，每个插入操作必须等到另一个线程调用移除操作，否则插入一直处于阻塞，
 *                  吞吐量高于LinkedBlockingQueue
 *
 * 阻塞队列：当队列为空时，获取队列元素时线程会被阻塞
 *            当队里满时，添加元素会被阻塞
 * 阻塞队列会管理线程何时需阻塞，何时需被唤醒
 *
 */
public class BlockingQueueDemo
{

    public static void main(String[] args)
    {



    }


}
