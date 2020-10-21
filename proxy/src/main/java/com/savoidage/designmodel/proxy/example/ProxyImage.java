package com.savoidage.designmodel.proxy.example;

/**
 * Author: created by savoidage
 * CreateTime: 2020-10-21 17:52
 * Description: 代理
 */
public class ProxyImage implements Image{

    private RealImage realImage;
    private String fileName;

    public ProxyImage(String fileName){
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if(realImage == null){
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }
}
