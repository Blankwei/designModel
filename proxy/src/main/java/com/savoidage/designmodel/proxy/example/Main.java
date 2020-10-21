package com.savoidage.designmodel.proxy.example;

/**
 * Author: created by savoidage
 * CreateTime: 2020-10-21 18:25
 * Description: main方法测试
 */
public class Main {

    public static void main(String[] args) {
        Image image = new ProxyImage("test_10mb.jpg");

        // 图像将从磁盘加载
        image.display();
        System.out.println("");
        // 图像不需要从磁盘加载
        image.display();
    }
}
