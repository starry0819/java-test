package com.zhanghuanfa.concurrency.in.practice.chapter04;

import com.zhanghuanfa.concurrency.in.practice.annotation.ThreadSafe;

/**
 * @author zhanghuanfa 2019-04-23 17:47
 */
@ThreadSafe
public class Counter {

    private long value = 0;

    public synchronized long getValue() {
        return value;
    }

    public synchronized long increment() {
        if (value == Long.MAX_VALUE) {
            throw new IllegalStateException("counter overflow");
        }
        return ++value;
    }
}
