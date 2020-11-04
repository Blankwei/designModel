package com.savoidage.designmodel.status.example;

/**
 * Author: created by savoidage
 * CreateTime: 2020-11-04 11:44
 * Description: 抽象状态流转方法
 */
public abstract class State {

    /**
     * 提交审核
     *
     * @param invoiceOrderId 发货单id
     * @param currentStatus  当前状态
     * @return 返回模组结果
     */
    public abstract ResultModel editCheck(Integer invoiceOrderId, Enum<Status> currentStatus);

    /**
     * 审核通过
     *
     * @param invoiceOrderId 发货单id
     * @param currentStatus  当前状态
     * @return 返回模组结果
     */
    public abstract ResultModel checkPass(Integer invoiceOrderId, Enum<Status> currentStatus);

    /**
     * 审核拒绝
     *
     * @param invoiceOrderId 发货单id
     * @param currentStatus  当前状态
     * @return 返回模组结果
     */
    public abstract ResultModel checkRefuse(Integer invoiceOrderId, Enum<Status> currentStatus);

    /**
     * 审核通过后取消
     *
     * @param invoiceOrderId 发货单id
     * @param currentStatus  当前状态
     * @return 返回模组结果
     */
    public abstract ResultModel passCancel(Integer invoiceOrderId, Enum<Status> currentStatus);

    /**
     * 审核拒绝后取消
     *
     * @param invoiceOrderId 发货单id
     * @param currentStatus  当前状态
     * @return 返回模组结果
     */
    public abstract ResultModel refuseCancel(Integer invoiceOrderId, Enum<Status> currentStatus);

    /**
     * 编辑取消
     *
     * @param invoiceOrderId 发货单id
     * @param currentStatus  当前状态
     * @return 返回模组结果
     */
    public abstract ResultModel editCancel(Integer invoiceOrderId, Enum<Status> currentStatus);
}
