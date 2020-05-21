package com.savoidage.designmodel.strategy.example;

import java.math.BigDecimal;

/**
 * Author: created by savoidage
 * CreateTime: 2020-05-21 17:29
 * Description: 打折策略接口
 */
public interface DiscountStrategy {

    // 满足于各种打折如八折、五折、一折、满减等活动
    // 计算打折后的价格
    BigDecimal getPrice(BigDecimal total);
}
