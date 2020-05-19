package com.savoidage.designmodel.abstractfactory.example;

/**
 * Author: created by savoidage
 * CreateTime: 2020-05-19 17:58
 * Description: Mysql工厂类
 */
public class MysqlFactory implements AbstractFactory {
    @Override
    public IUser createUser() {
        return new MysqlUser();
    }

}
