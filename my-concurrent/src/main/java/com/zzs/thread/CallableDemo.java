package com.zzs.thread;

import java.util.concurrent.Callable;

public class CallableDemo {
    public static void main(String[] args) {
        Thread t = new Thread();
        t.start();
    }

}
class MyThread implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        return 955;
    }
}