package com.zhanghuanfa.design.pattern.decorator.condiment;

import com.zhanghuanfa.design.pattern.decorator.Beverage;
import com.zhanghuanfa.design.pattern.decorator.CondimentDecorator;

/**
 * 摩卡配料
 *
 * @author zhanghuanfa 2019-03-28 00:13
 */
public class Mocha extends CondimentDecorator {

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }

    @Override
    public double cost() {
        return 0.20 + beverage.cost();
    }
}
