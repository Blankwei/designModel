package com.savoidage.designmodel.status.example.impl;

import com.savoidage.designmodel.status.example.InvoiceOrderService;
import com.savoidage.designmodel.status.example.ResultModel;
import com.savoidage.designmodel.status.example.State;
import com.savoidage.designmodel.status.example.Status;

/**
 * Author: created by savoidage
 * CreateTime: 2020-11-04 12:20
 * Description: 状态：创建/编辑
 */
public class EditingState extends State {

    @Override
    public ResultModel editCheck(Integer invoiceOrderId, Enum<Status> currentStatus) {
        InvoiceOrderService.changeStatus(invoiceOrderId,currentStatus,Status.Check);
        return new ResultModel("0000","待审核状态更改成功");
    }

    @Override
    public ResultModel checkPass(Integer invoiceOrderId, Enum<Status> currentStatus) {
        return new ResultModel("0000","待审核状态不可重复提审");
    }

    @Override
    public ResultModel checkRefuse(Integer invoiceOrderId, Enum<Status> currentStatus) {
        return new ResultModel("0000","待审核状态不可重复提审");
    }

    @Override
    public ResultModel passCancel(Integer invoiceOrderId, Enum<Status> currentStatus) {
        return new ResultModel("0000","待审核状态不可重复提审");
    }

    @Override
    public ResultModel refuseCancel(Integer invoiceOrderId, Enum<Status> currentStatus) {
        return new ResultModel("0000","待审核状态不可重复提审");
    }

    @Override
    public ResultModel editCancel(Integer invoiceOrderId, Enum<Status> currentStatus) {
        InvoiceOrderService.changeStatus(invoiceOrderId,currentStatus,Status.cancel);
        return new ResultModel("0000","取消状态更新成功");
    }
}
