package com.zhanghuanfa.design.pattern.builder;

import java.util.ArrayList;

/**
 * @author zhanghuanfa 2019-03-26 14:17
 */
public class BMWCarBuilder extends AbstractCarBuilder {

    private BMWCar bmwCar = new BMWCar();

    @Override
    void setSequence(ArrayList<String> sequence) {
        this.bmwCar.setSequence(sequence);
    }

    @Override
    AbstractCar getCar() {
        return this.bmwCar;
    }
}
