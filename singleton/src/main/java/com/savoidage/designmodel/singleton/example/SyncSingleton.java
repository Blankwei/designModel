package com.savoidage.designmodel.singleton.example;

/**
 * Author: created by savoidage
 * CreateTime: 2020-05-23 10:05
 * Description: 单例模式: 同步方法的懒汉式(可用)
 */
public class SyncSingleton {

    private static SyncSingleton singleton;

    /**
     * 私有构造方法(防止外部通过new创建对象)
     */
    private SyncSingleton(){

    }

    /**
     * 带有同步方法的懒汉式单例
     * @return
     */
    public static synchronized SyncSingleton getInstance(){
        if(null == singleton){
            singleton = new SyncSingleton();
        }
        return singleton;
    }
}
