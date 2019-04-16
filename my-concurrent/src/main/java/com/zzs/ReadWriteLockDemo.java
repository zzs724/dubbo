package com.zzs;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁
 * 读+读 共享
 * 写与任何都不能共享，写操作：原子性和独占，一个过程必须是完整的，不可被打断分割
 */
public class ReadWriteLockDemo {
    public static void main(String[] args) {
        final MyCache myCache = new MyCache();
        for (int i = 1; i <= 5 ; i++) {
            final int t = i;
            new Thread(new Runnable() {
                public void run() {
//                    myCache.put(t+"",t+"");
                    //加写锁
                    myCache.putLock(t+"",t+"");
                }
            },String.valueOf(i)).start();
        }
        for (int i = 1; i <= 5 ; i++) {
            final int t = i;
            new Thread(new Runnable() {
                public void run() {
//                    myCache.get(t+"");
                    //加读锁
                    myCache.getLock(t+"");
                }
            },String.valueOf(i)).start();
        }
    }
}

class MyCache {
    private volatile Map<String, Object> map = new HashMap<String, Object>();

    private ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();

    public void putLock(String key, Object value) {
        rwLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"\t 正在写入： "+ key);
            TimeUnit.SECONDS.sleep(3);
            map.put(key, value);
            System.out.println(Thread.currentThread().getName()+"\t 写入完成! ");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            rwLock.writeLock().unlock();
        }
    }

    public void getLock(String key) {
        rwLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"\t 正在读取 ");
            TimeUnit.SECONDS.sleep(2);
            Object o = map.get(key);
            System.out.println(Thread.currentThread().getName()+"\t 读取完成： "+ o);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            rwLock.readLock().unlock();
        }
    }


    public void put(String key, Object value) {
        System.out.println(Thread.currentThread().getName()+"\t 正在写入： "+ key);
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        map.put(key, value);
        System.out.println(Thread.currentThread().getName()+"\t 写入完成! ");
    }

    public void get(String key) {
        System.out.println(Thread.currentThread().getName()+"\t 正在读取 ");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Object o = map.get(key);
        System.out.println(Thread.currentThread().getName()+"\t 读取完成： "+ o);
    }

}
