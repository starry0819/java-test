package com.zhanghuanfa.design.pattern.builder;

import java.util.ArrayList;

/**
 * @author zhanghuanfa 2019-03-26 11:36
 */
public abstract class AbstractCarBuilder {

    abstract void setSequence(ArrayList<String> sequence);

    abstract AbstractCar getCar();
}
