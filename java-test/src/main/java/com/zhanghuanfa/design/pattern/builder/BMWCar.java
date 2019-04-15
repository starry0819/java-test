package com.zhanghuanfa.design.pattern.builder;

/**
 * @author zhanghuanfa 2019-03-26 14:16
 */
public class BMWCar extends AbstractCar {
    @Override
    protected void start() {
        System.out.println("BMW is starting like this");
    }

    @Override
    protected void alarm() {
        System.out.println("BMW is alarming like this");
    }

    @Override
    protected void stop() {
        System.out.println("BMW is stopping like this");
    }

    @Override
    protected void engineBoom() {
        System.out.println("BMW's engineBoom like this");
    }
}
