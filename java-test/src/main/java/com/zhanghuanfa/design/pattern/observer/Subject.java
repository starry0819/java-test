package com.zhanghuanfa.design.pattern.observer;

/**
 * @author zhanghuanfa 2019-03-27 22:18
 */
public interface Subject {

    /**
     * 注册观察者到主题
     * @param o 观察者
     */
    void registerObserver(Observer o);

    /**
     * 从主题删除观察者
     * @param o 观察者
     */
    void removeObserver(Observer o);

    /**
     * 通知所有已注册观察者
     */
    void notifyObservers();
}
