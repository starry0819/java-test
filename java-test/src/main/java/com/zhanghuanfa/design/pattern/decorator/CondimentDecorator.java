package com.zhanghuanfa.design.pattern.decorator;

/**
 * 饮料配料的抽象类
 *
 * @author zhanghuanfa 2019-03-28 00:06
 */
public abstract class CondimentDecorator extends Beverage {

    protected Beverage beverage;

    @Override
    public abstract String getDescription();
}
