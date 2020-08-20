package com.savoidage.designmodel.observer.example;

import lombok.extern.slf4j.Slf4j;

/**
 * Author: created by savoidage
 * CreateTime: 2020-08-20 08:25
 * Description: 具体观察者服务2
 */
@Slf4j
public class Service2Observer extends Observer {

    public Service2Observer(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        log.info("Service2Observer : " + subject.getState());
    }
}
