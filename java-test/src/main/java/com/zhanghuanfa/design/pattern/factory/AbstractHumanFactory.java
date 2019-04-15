package com.zhanghuanfa.design.pattern.factory;

/**
 * @author zhanghuanfa 2019-03-25 18:26
 */
public abstract class AbstractHumanFactory {

    abstract <T extends Human> T createHuman(Class<T> c);

}
