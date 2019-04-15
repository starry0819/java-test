package com.zhanghuanfa.design.pattern.decorator.beverage;

import com.zhanghuanfa.design.pattern.decorator.Beverage;

/**
 * 浓缩咖啡
 *
 * @author zhanghuanfa 2019-03-28 00:10
 */
public class Espresso extends Beverage {

    public Espresso() {
        description = "Espresso";
    }

    @Override
    public double cost() {
        return 1.99;
    }
}
