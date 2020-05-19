package com.savoidage.designmodel.abstractfactory.example;

/**
 * Author: created by savoidage
 * CreateTime: 2020-05-19 18:00
 * Description: mysql中的user表
 */
public class MysqlUser implements IUser {

    @Override
    public void insert(User user) {
        System.out.println("mysql 中添加一条user记录");
    }

    @Override
    public User getUser(int id) {
        System.out.println("mysql 中获取user记录");
        return null;
    }
}
