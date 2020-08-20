package com.savoidage.designmodel.observer.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: created by savoidage
 * CreateTime: 2020-08-19 21:21
 * Description: subject类
 */
public class Subject {

    private List<Observer> observers = new ArrayList<>();

    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    // 添加observer
    public void attach(Observer observer){
        observers.add(observer);
    }

    // 通知所有observer
    public void notifyAllObservers(){
        observers.forEach(Observer::update);
    }
}
