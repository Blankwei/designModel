package com.savoidage.designmodel.methodfactory.example;

/**
 * Author: created by savoidage
 * CreateTime: 2020-05-19 17:08
 * Description: 测试类main函数
 */
public class Main {

    // 工厂方法模式
    public static void main(String[] args) {
        // ipad工厂
        MyFactory factory = new IpadMonitorFactory();
        Monitor monitor = factory.createMonitor();
        monitor.produce();
    }
}
