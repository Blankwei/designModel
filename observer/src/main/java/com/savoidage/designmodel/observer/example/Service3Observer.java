package com.savoidage.designmodel.observer.example;

import lombok.extern.slf4j.Slf4j;

/**
 * Author: created by savoidage
 * CreateTime: 2020-08-20 08:27
 * Description: 具体观察者服务3
 */
@Slf4j
public class Service3Observer extends Observer{

    public Service3Observer(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        log.info("Service3Observer : " + subject.getState());
    }
}
