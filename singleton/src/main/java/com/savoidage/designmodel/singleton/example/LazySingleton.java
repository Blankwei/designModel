package com.savoidage.designmodel.singleton.example;

/**
 * Author: created by savoidage
 * CreateTime: 2020-05-23 10:00
 * Description: 单例模式: 懒汉式（线程不安全 不可用）
 */
public class LazySingleton {

    private static LazySingleton INSTANCE = null;

    /**
     * 私有构造方法(防止外部通过new创建对象)
     */
    private LazySingleton(){

    }

    /**
     * 懒汉式单例模式
     * @return
     */
    public static LazySingleton getInstance(){
        if(null == INSTANCE){
            // 当为空时 在类内部通过new创建实例
            INSTANCE = new LazySingleton();
        }
        return INSTANCE;
    }
}
