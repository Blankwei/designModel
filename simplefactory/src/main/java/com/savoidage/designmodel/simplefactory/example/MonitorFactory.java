package com.savoidage.designmodel.simplefactory.example;

/**
 * Author: created by savoidage
 * CreateTime: 2020-05-19 15:24
 * Description: 简单工厂：显示器类对象
 */
public class MonitorFactory {

    public Monitor createMonitor(String type){
        Monitor monitor = null;
        switch (type){
            // pc
            case "pc":
                monitor = new PCMonitor();
                break;
            // ipad
            case "ipad":
                monitor = new IpadMonitor();
                break;
            // tele
            case "tele":
                monitor = new TelevisionMonitor();
                break;
            default:
                // 默认pc
                monitor = new PCMonitor();
        }
        return monitor;
    }
}
