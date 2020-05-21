package com.savoidage.designmodel.strategy.example;

import java.math.BigDecimal;

/**
 * Author: created by savoidage
 * CreateTime: 2020-05-21 17:37
 * Description: 策略切换的上下文类
 */
public class DiscountContext {

    // 持有某个策略
    private DiscountStrategy strategy;

    // 设置新策略
    public void setStrategy(DiscountStrategy strategy) {
        this.strategy = strategy;
    }

    public void excute(BigDecimal total){
        System.out.println("金额：" + strategy.getPrice(total));
    }
}
