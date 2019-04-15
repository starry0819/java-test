package com.zhanghuanfa.design.pattern.builder;

import java.util.ArrayList;

/**
 * @author zhanghuanfa 2019-03-26 14:11
 */
public class BenzCarBuilder extends AbstractCarBuilder {

    private BenzCar benzCar = new BenzCar();

    @Override
    void setSequence(ArrayList<String> sequence) {
        this.benzCar.setSequence(sequence);
    }

    @Override
    AbstractCar getCar() {
        return this.benzCar;
    }
}
