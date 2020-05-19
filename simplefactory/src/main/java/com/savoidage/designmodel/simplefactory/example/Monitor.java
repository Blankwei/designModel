package com.savoidage.designmodel.simplefactory.example;

/**
 * Author: created by savoidage
 * CreateTime: 2020-05-19 15:45
 * Description: 具体对象操作
 */
public abstract class Monitor {

    protected String name;

    /**
     * 生产方法
     */
    public void produce(){
        System.out.println("生产了" + name + "显示器");
    }
}
