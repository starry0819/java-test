package com.zhanghuanfa.design.pattern;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhanghuanfa 2019-03-25 10:23
 */
public class Father {

    public Collection doSomething(Map map) {
        System.out.println("Father's do something");
        return map.values();
    }

    public static void main(String[] args) {
        Son son = new Son();
        Map map = new HashMap(4);
        son.doSomething(map);
        HashMap hashMap = new HashMap(4);
        son.doSomething(hashMap);
    }
}

class Son extends Father {

    public Collection doSomething(HashMap map) {
        System.out.println("Son's do something");
        return map.values();
    }
}
