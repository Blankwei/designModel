package com.savoidage.designmodel.singleton.example;

/**
 * Author: created by savoidage
 * CreateTime: 2020-05-23 10:14
 * Description: 单例模式: 静态内部类（可用 推荐）
 */
public class StaticInnerSingleton {

    /**
     * 私有构造方法(防止外部通过new创建对象)
     */
    private StaticInnerSingleton(){

    }

    /**
     * 内部静态类
     */
    private static class SingletonInstance{
        private static final StaticInnerSingleton SINGLETON = new StaticInnerSingleton();
    }

    /**
     * 内部静态实例获取
     * @return
     */
    public static StaticInnerSingleton getInstance(){
        return SingletonInstance.SINGLETON;
    }
}
