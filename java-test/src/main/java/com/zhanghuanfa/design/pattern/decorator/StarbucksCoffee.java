package com.zhanghuanfa.design.pattern.decorator;

import com.zhanghuanfa.design.pattern.decorator.beverage.Espresso;
import com.zhanghuanfa.design.pattern.decorator.beverage.HouseBlend;
import com.zhanghuanfa.design.pattern.decorator.condiment.Mocha;
import com.zhanghuanfa.design.pattern.decorator.condiment.Soy;

/**
 * @author zhanghuanfa 2019-03-28 14:15
 */
public class StarbucksCoffee {

    public static void main(String[] args) {
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription() + " $ " + beverage.cost());

        Beverage beverage1 = new HouseBlend();
        beverage1 = new Mocha(beverage1);
        beverage1 = new Mocha(beverage1);
        beverage1 = new Soy(beverage1);
        System.out.println(beverage1.getDescription() + " $ " + beverage1.cost());
    }
}
