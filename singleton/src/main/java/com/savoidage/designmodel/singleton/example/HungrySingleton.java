package com.savoidage.designmodel.singleton.example;

/**
 * Author: created by savoidage
 * CreateTime: 2020-05-23 09:46
 * Description: 单例模式: 饿汉式(可用)
 */
public class HungrySingleton {

    private static HungrySingleton INSTANCE = new HungrySingleton();

    /**
     * 私有构造方法(防止外部通过new创建对象)
     */
    private HungrySingleton(){

    }

    /**
     * 饿汉式单例模式
     * @return
     */
    public static HungrySingleton getInstance(){
        return INSTANCE;
    }

}
