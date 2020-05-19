package com.savoidage.designmodel.abstractfactory.example;

/**
 * Author: created by savoidage
 * CreateTime: 2020-05-19 17:54
 * Description: IUser接口
 */
public interface IUser {

    void insert(User user);

    User getUser(int id);
}
