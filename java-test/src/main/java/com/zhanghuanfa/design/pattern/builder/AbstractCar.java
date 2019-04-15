package com.zhanghuanfa.design.pattern.builder;

import java.util.ArrayList;

/**
 * @author zhanghuanfa 2019-03-26 11:19
 */
public abstract class AbstractCar {

    private ArrayList<String> sequence = new ArrayList<>();

    /**启动*/
    protected abstract void start();

    /**喇叭*/
    protected abstract void alarm();

    /**停止*/
    protected abstract void stop();

    /**引擎*/
    protected abstract void engineBoom();

    final void run() {
        for (String s : sequence) {
            if ("start".equalsIgnoreCase(s)) {
                start();
            }
            if ("alarm".equalsIgnoreCase(s)) {
                alarm();
            }
            if ("stop".equalsIgnoreCase(s)) {
                stop();
            }
            if ("engineBoom".equalsIgnoreCase(s)) {
                engineBoom();
            }
        }
    }

    final void setSequence(ArrayList<String> sequence) {
        this.sequence = sequence;
    }
}
