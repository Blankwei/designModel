package com.savoidage.designmodel.abstractfactory.example;

/**
 * Author: created by savoidage
 * CreateTime: 2020-05-19 18:06
 * Description: oracle中的user表
 */
public class OracleUser implements IUser {

    @Override
    public void insert(User user) {
        System.out.println("在 oracle 中插入一条user 记录");
    }

    @Override
    public User getUser(int id) {
        System.out.println("在 oracle 中通过id 获取user表记录");
        return null;
    }
}
