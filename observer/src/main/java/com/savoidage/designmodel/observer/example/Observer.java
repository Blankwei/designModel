package com.savoidage.designmodel.observer.example;

/**
 * Author: created by savoidage
 * CreateTime: 2020-08-20 08:15
 * Description: 创建observer类
 */
public abstract class Observer {

    protected Subject subject;

    public abstract void update();
}
