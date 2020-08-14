package com.savoidage.designmodel.prototype.example;

import lombok.extern.slf4j.Slf4j;

/**
 * Author: created by savoidage
 * CreateTime: 2020-08-14 15:52
 * Description: 长期班
 */
@Slf4j
public class LongTermClass extends ClassInfo{

    public LongTermClass(){
        classType = "long-term";
    }

    @Override
    public void print() {
        log.info("excute longTerm::print() method...");
    }
}
