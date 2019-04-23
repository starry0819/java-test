package com.zhanghuanfa.concurrency.in.practice.chapter03;

/**
 * @author zhanghuanfa 2019-04-18 17:57
 */
public class SynchronizedInteger {

    private int value;

    public synchronized int get() {
        return value;
    }

    public synchronized void set(int value) {
        this.value = value;
    }
}
