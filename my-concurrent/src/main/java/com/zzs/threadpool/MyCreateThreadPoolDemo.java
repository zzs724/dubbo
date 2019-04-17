package com.zzs.threadpool;

import java.util.concurrent.*;

/**
 * 自定义创建线程池
 */
public class MyCreateThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService threadPool = new ThreadPoolExecutor(
                2,
                5,
                1L,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<Runnable>(3),
                Executors.defaultThreadFactory(),
//                new ThreadPoolExecutor.AbortPolicy());//直接抛异常：RejectedExecutionException
//                new ThreadPoolExecutor.CallerRunsPolicy());//返回给发起任务的调用者，谁调用的线程就返给谁
//                new ThreadPoolExecutor.DiscardOldestPolicy());//抛弃阻塞队列中等待最久的，尝试将当前任务加入队列再次提交任务
                new ThreadPoolExecutor.DiscardPolicy());//直接将无法处理的任务丢弃

        try {
            for (int i = 1; i <= 15; i++)
            {
                final int a = i;
                threadPool.execute(() ->{

                    System.out.println(Thread.currentThread().getName()+"\t 办理业务"+a);
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }
}
