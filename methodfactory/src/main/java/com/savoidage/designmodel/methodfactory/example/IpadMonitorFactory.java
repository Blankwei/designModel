package com.savoidage.designmodel.methodfactory.example;

/**
 * Author: created by savoidage
 * CreateTime: 2020-05-19 17:06
 * Description: ipad工厂
 */
public class IpadMonitorFactory implements MyFactory {
    @Override
    public Monitor createMonitor() {
        return new IpadMonitor();
    }
}
