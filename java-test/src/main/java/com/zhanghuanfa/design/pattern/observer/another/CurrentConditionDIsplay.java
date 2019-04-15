package com.zhanghuanfa.design.pattern.observer.another;

import com.zhanghuanfa.design.pattern.observer.DisplayElement;

import java.util.Observable;
import java.util.Observer;

/**
 * @author zhanghuanfa 2019-03-27 23:14
 */
public class CurrentConditionDIsplay implements Observer, DisplayElement {

    private Observable observable;
    private float temperature;
    private float humidity;

    public CurrentConditionDIsplay(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Current Conditions: " + temperature
                + "F degrees and " + humidity + "% humidity");
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) o;
            this.temperature = weatherData.getTemperature();
            this.humidity = weatherData.getHumidity();
            display();
        }
    }
}
