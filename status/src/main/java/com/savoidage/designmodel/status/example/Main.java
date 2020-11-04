package com.savoidage.designmodel.status.example;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

/**
 * Author: created by savoidage
 * CreateTime: 2020-11-04 10:34
 * Description: main函数测试
 */
@Slf4j
public class Main {
//    public static void main(String[] args) {
//        // 初始化数据
//        Integer invoiceOrderId = 100001;
//        InvoiceOrderService.init(invoiceOrderId,Status.Editing);
//
//        InvoiceOrderChangeStatusController controller = new InvoiceOrderChangeStatusController();
//        ResultModel resultModel = controller.changeStatus(invoiceOrderId, Status.Editing, Status.Check);
//        log.info("测试结果(创建/编辑中To审核中)：{}",JSON.toJSONString(resultModel));
//
//        ResultModel model = controller.changeStatus(invoiceOrderId, Status.Editing, Status.Pass);
//        log.info("测试结果(创建/编辑中To审核通过)：{}",JSON.toJSONString(model));
//    }

    public static void main(String[] args) {
        // 初始化数据
        Integer invoiceOrderId1 = 100001;
        InvoiceOrderService.init(invoiceOrderId1,Status.Editing);

        StateHandler handler1 = new StateHandler();
        ResultModel model1 = handler1.editCheck(invoiceOrderId1, Status.Editing);

        log.info("测试结果(编辑中To待审核)：{}", JSON.toJSONString(model1));
        log.info("活动信息：{} 状态：{}", JSON.toJSONString(InvoiceOrderService.queryInvoiceOrderInfo(invoiceOrderId1)), JSON.toJSONString(InvoiceOrderService.queryInvoiceOrderInfo(invoiceOrderId1).getStatus()));


        // 初始化数据
        Integer invoiceOrderId2 = 100002;
        InvoiceOrderService.init(invoiceOrderId2,Status.Check);

        StateHandler handler2 = new StateHandler();
        ResultModel model2 = handler2.checkPass(invoiceOrderId2, Status.Check);

        log.info("测试结果(待审核To审核通过)：{}", JSON.toJSONString(model2));
        log.info("活动信息：{} 状态：{}", JSON.toJSONString(InvoiceOrderService.queryInvoiceOrderInfo(invoiceOrderId2)), JSON.toJSONString(InvoiceOrderService.queryInvoiceOrderInfo(invoiceOrderId2).getStatus()));

        Integer invoiceOrderId3 = 100003;
        InvoiceOrderService.init(invoiceOrderId3,Status.Pass);

        StateHandler handler3 = new StateHandler();
        ResultModel model3 = handler3.passCancel(invoiceOrderId3, Status.Pass);

        log.info("测试结果(审核通过To取消)：{}", JSON.toJSONString(model3));
        log.info("活动信息：{} 状态：{}", JSON.toJSONString(InvoiceOrderService.queryInvoiceOrderInfo(invoiceOrderId3)), JSON.toJSONString(InvoiceOrderService.queryInvoiceOrderInfo(invoiceOrderId3).getStatus()));
    }
}
