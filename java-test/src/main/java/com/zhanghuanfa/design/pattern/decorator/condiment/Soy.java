package com.zhanghuanfa.design.pattern.decorator.condiment;

import com.zhanghuanfa.design.pattern.decorator.Beverage;
import com.zhanghuanfa.design.pattern.decorator.CondimentDecorator;

/**
 * @author zhanghuanfa 2019-03-28 14:11
 */
public class Soy extends CondimentDecorator {

    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return this.beverage.getDescription() + ", Soy";
    }

    @Override
    public double cost() {
        return 0.2 + this.beverage.cost();
    }
}
