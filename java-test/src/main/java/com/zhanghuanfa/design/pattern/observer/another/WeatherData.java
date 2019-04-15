package com.zhanghuanfa.design.pattern.observer.another;

import lombok.Getter;

import java.util.Observable;

/**
 * @author zhanghuanfa 2019-03-27 23:09
 */
@Getter
public class WeatherData extends Observable {

    private float temperature;
    private float humidity;
    private float pressure;

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

    public void measurementsChanged() {
        setChanged();
        notifyObservers();
    }

}
