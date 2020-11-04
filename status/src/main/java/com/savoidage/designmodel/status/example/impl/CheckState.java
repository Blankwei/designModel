package com.savoidage.designmodel.status.example.impl;

import com.savoidage.designmodel.status.example.InvoiceOrderService;
import com.savoidage.designmodel.status.example.ResultModel;
import com.savoidage.designmodel.status.example.State;
import com.savoidage.designmodel.status.example.Status;

/**
 * Author: created by savoidage
 * CreateTime: 2020-11-04 11:55
 * Description: 状态：待审核
 */
public class CheckState extends State {

    @Override
    public ResultModel editCheck(Integer invoiceOrderId, Enum<Status> currentStatus) {
        return new ResultModel("0000","待审核状态不可重复提审");
    }

    @Override
    public ResultModel checkPass(Integer invoiceOrderId, Enum<Status> currentStatus) {
        InvoiceOrderService.changeStatus(invoiceOrderId,currentStatus,Status.Pass);
        return new ResultModel("0000","发货单审核状态完成");
    }

    @Override
    public ResultModel checkRefuse(Integer invoiceOrderId, Enum<Status> currentStatus) {
        InvoiceOrderService.changeStatus(invoiceOrderId,currentStatus,Status.Refuse);
        return new ResultModel("0000","发货单审核被拒绝");
    }

    @Override
    public ResultModel passCancel(Integer invoiceOrderId, Enum<Status> currentStatus) {
        return new ResultModel("0000","未审核通过不可取消");
    }

    @Override
    public ResultModel refuseCancel(Integer invoiceOrderId, Enum<Status> currentStatus) {
        return new ResultModel("0000","未拒绝审核不可取消");
    }

    @Override
    public ResultModel editCancel(Integer invoiceOrderId, Enum<Status> currentStatus) {
        return new ResultModel("0000","未拒绝审核不可取消");
    }
}
