package com.savoidage.designmodel.singleton.example;

/**
 * Author: created by savoidage
 * CreateTime: 2020-05-23 09:58
 * Description: 函数测试类
 */
public class Main {
    public static void main(String[] args) {
        // 饿汉式
        HungrySingleton instance1 = HungrySingleton.getInstance();
        HungrySingleton instance2 = HungrySingleton.getInstance();
        if(instance1 == instance2){
            System.out.println("【饿汉式】：生成的实例相同~");
        }

        // 懒汉式
        LazySingleton instance = LazySingleton.getInstance();
        LazySingleton instance3 = LazySingleton.getInstance();
        if(instance == instance3){
            System.out.println("【懒汉式】：生成的实例相同~");
        }

        // 同步懒汉式
        SyncSingleton instance4 = SyncSingleton.getInstance();
        SyncSingleton instance5 = SyncSingleton.getInstance();
        if(instance4 == instance5){
            System.out.println("【同步懒汉式】：生成的实例相同~");
        }

        // 双重检查懒汉式
        DoubleCheckLockSingleton instance6 = DoubleCheckLockSingleton.getInstance();
        DoubleCheckLockSingleton instance7 = DoubleCheckLockSingleton.getInstance();
        if(instance6 == instance7){
            System.out.println("【双重检查懒汉式】：生成的实例相同~");
        }

        // 静态内部类
        StaticInnerSingleton instance8 = StaticInnerSingleton.getInstance();
        StaticInnerSingleton instance9 = StaticInnerSingleton.getInstance();
        if(instance8 == instance9){
            System.out.println("【静态内部类】：生成的实例相同~");
        }

        // 枚举
        EnumSingleton singleton = EnumSingleton.SINGLETON;
        EnumSingleton singleton1 = EnumSingleton.SINGLETON;
        if(singleton == singleton1){
            System.out.println("【枚举】：生成的实例相同~");
        }
    }
}
