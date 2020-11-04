package com.savoidage.designmodel.status.example;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Author: created by savoidage
 * CreateTime: 2020-11-04 10:45
 * Description: 发货单逻辑服务
 */
public class InvoiceOrderService {

    private static Map<String, Enum<Status>> statusMap = new ConcurrentHashMap<>();

    public static void init(Integer invoiceOrderId, Enum<Status> status) {
        // 模拟查询发货单信息
        InvoiceOrderInfo invoiceOrderInfo = new InvoiceOrderInfo();
        invoiceOrderInfo.setInvoiceOrderId(invoiceOrderId);
        invoiceOrderInfo.setInvoiceOrderName("深圳发往杭州货件");
        invoiceOrderInfo.setStatus(status);
        invoiceOrderInfo.setCreateDate(new Date());
        invoiceOrderInfo.setUpdateDate(new Date());
        statusMap.put(String.valueOf(invoiceOrderId), status);
    }

    /**
     * 查询发货单信息
     *
     * @param invoiceOrderId 发货单id
     * @return 查询结果
     */
    public static InvoiceOrderInfo queryInvoiceOrderInfo(Integer invoiceOrderId) {
        // 模拟查询发货单信息
        InvoiceOrderInfo invoiceOrderInfo = new InvoiceOrderInfo();
        invoiceOrderInfo.setInvoiceOrderId(invoiceOrderId);
        invoiceOrderInfo.setInvoiceOrderName("深圳发往杭州货件");
        invoiceOrderInfo.setStatus(statusMap.get(invoiceOrderId.toString()));
        invoiceOrderInfo.setCreateDate(new Date());
        invoiceOrderInfo.setUpdateDate(new Date());
        return invoiceOrderInfo;
    }

    /**
     * 变更状态
     *
     * @param invoiceOrderId 发货单id
     * @param beforeStatus   变更前状态
     * @param afterStatus    变更后状态
     */
    public static synchronized void changeStatus(Integer invoiceOrderId, Enum<Status> beforeStatus, Enum<Status> afterStatus) {
        if (!beforeStatus.equals(statusMap.get(invoiceOrderId.toString()))) {
            return;
        }
        statusMap.put(invoiceOrderId.toString(), afterStatus);
    }
}
