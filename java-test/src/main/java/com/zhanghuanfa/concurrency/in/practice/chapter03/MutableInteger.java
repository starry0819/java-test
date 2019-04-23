package com.zhanghuanfa.concurrency.in.practice.chapter03;

/**
 * @author zhanghuanfa 2019-04-18 17:56
 */
public class MutableInteger {

    private int value;

    public int get() {
        return value;
    }

    public void set(int value) {
        this.value = value;
    }
}
