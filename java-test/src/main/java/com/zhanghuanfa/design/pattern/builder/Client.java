package com.zhanghuanfa.design.pattern.builder;

import java.util.ArrayList;

/**
 * @author zhanghuanfa 2019-03-26 11:57
 */
public class Client {

    public static void main(String[] args) {
        ArrayList<String> sequence = new ArrayList<>();
        sequence.add("engineBoom");
        sequence.add("start");
        sequence.add("stop");
        BenzCarBuilder benzCarBuilder = new BenzCarBuilder();
        benzCarBuilder.setSequence(sequence);
        BenzCar benzCar = (BenzCar) benzCarBuilder.getCar();
        benzCar.run();
    }
}

