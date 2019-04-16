package com.zzs;

/**
 * ArrayBlockingQueue：一个基于数组结构的有界阻塞队列，此队列安FIFO先进先出原则对原始排序
 * LinkedBlockingQueue：一个基于链表结构，此队列安FIFO先进先出原则对原始排序，吞吐量高于ArrayBlockingQueue
 * SynchronousQueue：不存储元素的阻塞队列，每个插入操作必须等到另一个线程调用移除操作，否则插入一直处于阻塞，
 *                  吞吐量高于LinkedBlockingQueue
 *
 *
 */
public class BlockingQueueDemo {
}
