package com.savoidage.designmodel.observer.example;

/**
 * Author: created by savoidage
 * CreateTime: 2020-08-20 08:31
 * Description: main 方法测试
 */
public class Main {
    public static void main(String[] args) {
        Subject subject = new Subject();

        new Service1Observer(subject);
        new Service2Observer(subject);
        new Service3Observer(subject);

        System.out.println("state being setted: 11");
        subject.setState(11);

        System.out.println("then state being changed: 13");
        subject.setState(13);

    }
}
