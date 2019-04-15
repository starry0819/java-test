package com.zhanghuanfa.design.pattern.factory;

/**
 * @author zhanghuanfa 2019-03-25 18:30
 */
public class WhiteHuman implements Human {

    @Override
    public void getColor() {
        System.out.println("白种人");
    }

    @Override
    public void getLanguage() {
        System.out.println("白种人说英文");
    }
}
