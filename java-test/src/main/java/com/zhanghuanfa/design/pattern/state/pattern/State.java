package com.zhanghuanfa.design.pattern.state.pattern;

/**
 * @author zhanghuanfa 2019-04-15 14:47
 */
public interface State {

    void insertQuarter();

    void ejectQuarter();

    void turnCrank();

    void dispense();
}
