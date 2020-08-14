package com.savoidage.designmodel.prototype.example;

import java.util.Hashtable;

/**
 * Author: created by savoidage
 * CreateTime: 2020-08-14 15:55
 * Description: 创建班级类返回班级的原型
 */
public class ClassInfoPrototype {

    private static Hashtable<String,ClassInfo> classInfoHashtable = new Hashtable<>();

    public static ClassInfo getClassInfo(String id){
        ClassInfo classInfo = classInfoHashtable.get(id);
        return (ClassInfo) classInfo.clone();
    }

    // 默认添加班级类型
    public static void loadCache(){
        WisdomClass wisdomClass = new WisdomClass();
        wisdomClass.setId("1");
        classInfoHashtable.put(wisdomClass.getId(),wisdomClass);

        LongTermClass longTermClass = new LongTermClass();
        longTermClass.setId("2");
        classInfoHashtable.put(longTermClass.getId(),longTermClass);
    }
}
