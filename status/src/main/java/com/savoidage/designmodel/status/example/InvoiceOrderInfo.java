package com.savoidage.designmodel.status.example;

import lombok.Data;

import java.util.Date;

/**
 * Author: created by savoidage
 * CreateTime: 2020-11-04 10:37
 * Description: 发货单信息
 */
@Data
public class InvoiceOrderInfo {

    // 发货单id
    private Integer invoiceOrderId;

    // 发货单名称
    private String invoiceOrderName;

    // 发货单状态
    private Enum<Status> status;

    // 创建时间
    private Date createDate;

    // 更新时间
    private Date updateDate;

}
