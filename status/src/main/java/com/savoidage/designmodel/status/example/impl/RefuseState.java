package com.savoidage.designmodel.status.example.impl;

import com.savoidage.designmodel.status.example.InvoiceOrderService;
import com.savoidage.designmodel.status.example.ResultModel;
import com.savoidage.designmodel.status.example.State;
import com.savoidage.designmodel.status.example.Status;

/**
 * Author: created by savoidage
 * CreateTime: 2020-11-04 12:19
 * Description: 状态：审核被拒
 */
public class RefuseState extends State {

    @Override
    public ResultModel editCheck(Integer invoiceOrderId, Enum<Status> currentStatus) {
        return new ResultModel("0000","状态已拒绝不可编辑");
    }

    @Override
    public ResultModel checkPass(Integer invoiceOrderId, Enum<Status> currentStatus) {
        return new ResultModel("0000","状态已拒绝不可通过审核");
    }

    @Override
    public ResultModel checkRefuse(Integer invoiceOrderId, Enum<Status> currentStatus) {
        return new ResultModel("0000","不可重复拒绝");
    }

    @Override
    public ResultModel passCancel(Integer invoiceOrderId, Enum<Status> currentStatus) {
        return new ResultModel("0000","状态不是审核通过不可取消");
    }

    @Override
    public ResultModel refuseCancel(Integer invoiceOrderId, Enum<Status> currentStatus) {
        InvoiceOrderService.changeStatus(invoiceOrderId,currentStatus,Status.cancel);
        return new ResultModel("0000","取消成功");
    }

    @Override
    public ResultModel editCancel(Integer invoiceOrderId, Enum<Status> currentStatus) {
        return new ResultModel("0000","状态不是编辑更新不可取消");
    }
}
