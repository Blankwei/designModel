package com.savoidage.designmodel.status.example.impl;

import com.savoidage.designmodel.status.example.InvoiceOrderService;
import com.savoidage.designmodel.status.example.ResultModel;
import com.savoidage.designmodel.status.example.State;
import com.savoidage.designmodel.status.example.Status;

/**
 * Author: created by savoidage
 * CreateTime: 2020-11-04 12:08
 * Description: 状态：审核通过
 */
public class PassState extends State {

    @Override
    public ResultModel editCheck(Integer invoiceOrderId, Enum<Status> currentStatus) {
        return new ResultModel("0000","审核通过不可重复提审");
    }

    @Override
    public ResultModel checkPass(Integer invoiceOrderId, Enum<Status> currentStatus) {
        return new ResultModel("0000","审核已通过不可重复通过审核");
    }

    @Override
    public ResultModel checkRefuse(Integer invoiceOrderId, Enum<Status> currentStatus) {
        return new ResultModel("0000","审核已通过不可拒绝审核");
    }

    @Override
    public ResultModel passCancel(Integer invoiceOrderId, Enum<Status> currentStatus) {
        InvoiceOrderService.changeStatus(invoiceOrderId,currentStatus,Status.cancel);
        return new ResultModel("0000","状态取消成功");
    }

    @Override
    public ResultModel refuseCancel(Integer invoiceOrderId, Enum<Status> currentStatus) {
        return new ResultModel("0000","状态不是拒绝审核不可取消");
    }

    @Override
    public ResultModel editCancel(Integer invoiceOrderId, Enum<Status> currentStatus) {
        return new ResultModel("0000","状态不是编辑更新不可取消");
    }
}
