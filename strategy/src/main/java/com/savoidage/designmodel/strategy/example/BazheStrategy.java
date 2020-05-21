package com.savoidage.designmodel.strategy.example;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Author: created by savoidage
 * CreateTime: 2020-05-21 17:39
 * Description: 具体策略：八折
 */
public class BazheStrategy implements DiscountStrategy {

    @Override
    public BigDecimal getPrice(BigDecimal total) {
        System.out.println("此次账单打八折：");
        // 设置八折并四舍五入保留两位小数
        return total.multiply(new BigDecimal("0.8").setScale(2,RoundingMode.HALF_UP));
    }
}
