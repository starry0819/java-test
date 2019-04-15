package com.zhanghuanfa.design.pattern.builder;

/**
 * @author zhanghuanfa 2019-03-26 11:34
 */
public class BenzCar extends AbstractCar {
    @Override
    protected void start() {
        System.out.println("Benz is starting like this");
    }

    @Override
    protected void alarm() {
        System.out.println("Benz is alarming like this");
    }

    @Override
    protected void stop() {
        System.out.println("Benz is stopping like this");
    }

    @Override
    protected void engineBoom() {
        System.out.println("Benz's engineBoom like this");
    }
}
