package com.savoidage.designmodel.strategy.example;

import java.math.BigDecimal;

/**
 * Author: created by savoidage
 * CreateTime: 2020-05-21 18:07
 * Description: 具体策略：满减
 */
public class FullDecrementStrategy implements DiscountStrategy{

    @Override
    public BigDecimal getPrice(BigDecimal total) {
        System.out.println("此次账单满200减20: ");
        // 满200减20
        return total.compareTo(BigDecimal.valueOf(200)) >= 0 ? total.subtract(BigDecimal.valueOf(20)).setScale(2) : total;
    }
}
