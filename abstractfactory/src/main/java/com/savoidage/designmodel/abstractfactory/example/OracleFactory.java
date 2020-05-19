package com.savoidage.designmodel.abstractfactory.example;

/**
 * Author: created by savoidage
 * CreateTime: 2020-05-19 17:59
 * Description: Oracle工厂类
 */
public class OracleFactory implements AbstractFactory {
    @Override
    public IUser createUser() {
        return new OracleUser();
    }

}
