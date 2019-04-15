package com.zhanghuanfa.design.pattern.observer.another;

import java.util.Observer;

/**
 * @author zhanghuanfa 2019-03-27 23:17
 */
public class WeatherStation {

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        Observer currentDiplay = new CurrentConditionDIsplay(weatherData);
        weatherData.setMeasurements(80, 65, 30.4f);
    }
}
