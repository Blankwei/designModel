package com.savoidage.designmodel.singleton.example;

/**
 * Author: created by savoidage
 * CreateTime: 2020-05-23 10:09
 * Description: 单例模式: 双重检查懒汉式（可用 推荐）
 */
public class DoubleCheckLockSingleton {

    private static DoubleCheckLockSingleton singleton = null;

    private static final Byte[] bytes = new Byte[0];

    /**
     * 私有构造方法(防止外部通过new创建对象)
     */
    private DoubleCheckLockSingleton(){

    }

    /**
     * 双重效验+锁模式
     * @return
     */
    public static DoubleCheckLockSingleton getInstance(){
        if(null == singleton){
            // 锁字节 提升效率
            synchronized(bytes){
                if(null == singleton){
                    singleton = new DoubleCheckLockSingleton();
                }
            }
        }
        return singleton;
    }
}
