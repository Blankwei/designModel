package com.savoidage.designmodel.prototype.example;

import lombok.extern.slf4j.Slf4j;

/**
 * Author: created by savoidage
 * CreateTime: 2020-08-14 15:49
 * Description: 智慧班
 */
@Slf4j
public class WisdomClass extends ClassInfo {

    public WisdomClass(){
        classType = "wisdom";
    }

    @Override
    public void print() {
        log.info("excute wisdom::print() method...");
    }

}
