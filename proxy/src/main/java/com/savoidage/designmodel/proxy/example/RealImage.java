package com.savoidage.designmodel.proxy.example;

/**
 * Author: created by savoidage
 * CreateTime: 2020-10-21 17:52
 * Description:
 */
public class RealImage implements Image{

    private String fileName;

    public RealImage(String fileName){
        this.fileName = fileName;
        loadFromDisk(fileName);
    }

    @Override
    public void display() {
        System.out.println("Displaying " + fileName);
    }

    private void loadFromDisk(String fileName){
        System.out.println("Loading " + fileName);
    }
}
