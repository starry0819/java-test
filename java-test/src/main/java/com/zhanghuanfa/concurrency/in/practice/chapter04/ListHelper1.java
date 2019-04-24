package com.zhanghuanfa.concurrency.in.practice.chapter04;

import com.zhanghuanfa.concurrency.in.practice.annotation.NotThreadSafe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author zhanghuanfa 2019-04-24 11:46
 */
@NotThreadSafe
public class ListHelper1<E> {

    public List<E> list = Collections.synchronizedList(new ArrayList<>());

    public synchronized boolean putIfAbsent(E e) {
        boolean absent = !list.contains(e);
        if (absent) {
            list.add(e);
        }
        return absent;
    }

    public List<E> getList() {
        return list;
    }

    public static void main(String[] args) {

    }
}
