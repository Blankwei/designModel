package com.savoidage.designmodel.strategy.example;

import java.math.BigDecimal;

/**
 * Author: created by savoidage
 * CreateTime: 2020-05-21 18:14
 * Description: 函数测试类
 */
public class Main {

    public static void main(String[] args) {
        DiscountContext context = new DiscountContext();
        // 八折
        context.setStrategy(new BazheStrategy());
        context.excute(new BigDecimal(180));

        // 满减
        context.setStrategy(new FullDecrementStrategy());
        context.excute(new BigDecimal(250));

    }
}
