package com.savoidage.designmodel.prototype.example;

import lombok.extern.slf4j.Slf4j;

/**
 * Author: created by savoidage
 * CreateTime: 2020-08-14 16:26
 * Description: main 方法测试
 */
@Slf4j
public class Main {

    public static void main(String[] args) {
        // 加载数据
        ClassInfoPrototype.loadCache();

        ClassInfo wisdomClassInfo = ClassInfoPrototype.getClassInfo("1");
        log.info("classInfo: " + wisdomClassInfo.getClassType());

        ClassInfo longTermClassInfo = ClassInfoPrototype.getClassInfo("2");
        log.info("classInfo: " + longTermClassInfo.getClassType());
    }

}
