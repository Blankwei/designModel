package com.savoidage.designmodel.simplefactory.example;

/**
 * Author: created by savoidage
 * CreateTime: 2020-05-19 16:02
 * Description: 测试类
 */
public class Main {

    // 简单工厂模式
    public static void main(String[] args) {
        MonitorFactory factory = new MonitorFactory();
        Monitor monitor = factory.createMonitor("pc");
        monitor.produce();

        factory.createMonitor("ipad").produce();
    }
}
