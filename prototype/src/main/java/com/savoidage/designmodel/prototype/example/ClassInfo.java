package com.savoidage.designmodel.prototype.example;

/**
 * Author: created by savoidage
 * CreateTime: 2020-08-14 15:38
 * Description: 班级信息
 */
public abstract class ClassInfo implements Cloneable{

    private String id;

    protected String classType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClassType(){
        return classType;
    }

    abstract void print();

    @Override
    public Object clone(){
        Object clone = null;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }

}
