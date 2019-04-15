package com.zhanghuanfa.design.pattern.factory;

/**
 * @author zhanghuanfa 2019-03-25 18:28
 */
public class HumanFactory extends AbstractHumanFactory {
    @Override
    <T extends Human> T createHuman(Class<T> c) {
        Human human = null;
        try {
            human = (Human) Class.forName(c.getName()).newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return (T)human;
    }
}
