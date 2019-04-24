package com.zhanghuanfa.concurrency.in.practice.chapter04;

import com.zhanghuanfa.concurrency.in.practice.annotation.ThreadSafe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author zhanghuanfa 2019-04-24 11:46
 */
@ThreadSafe
public class ListHelper2<E> {

    public List<E> list = Collections.synchronizedList(new ArrayList<>());

    public boolean putIfAbsent(E e) {
        synchronized (list) {
            boolean absent = !list.contains(e);
            if (absent) {
                list.add(e);
            }
            return absent;
        }
    }

    public List<E> getList() {
        return list;
    }


}
