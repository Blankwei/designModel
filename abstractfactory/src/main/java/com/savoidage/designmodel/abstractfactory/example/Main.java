package com.savoidage.designmodel.abstractfactory.example;

/**
 * Author: created by savoidage
 * CreateTime: 2020-05-19 18:11
 * Description: 测试main函数
 */
public class Main {

    // 抽象工厂模式
    public static void main(String[] args) {
        User user = new User();
        AbstractFactory factory = new MysqlFactory();
        IUser iUser = factory.createUser();
        iUser.insert(user);
        iUser.getUser(1);

        factory = new OracleFactory();
        IUser user1 = factory.createUser();
        user1.insert(user);
        user1.getUser(1);
    }
}
