package com.zhanghuanfa.design.pattern.decorator.beverage;

import com.zhanghuanfa.design.pattern.decorator.Beverage;

/**
 * @author zhanghuanfa 2019-03-28 00:12
 */
public class HouseBlend extends Beverage {

    public HouseBlend() {
        description = "House Blend";
    }

    @Override
    public double cost() {
        return 0.89;
    }
}
