package com.zhanghuanfa.design.pattern.decorator;

/**
 * 饮料抽象类
 *
 * @author zhanghuanfa 2019-03-28 00:05
 */
public abstract class Beverage {

    protected String description = "Unknown description";

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}
