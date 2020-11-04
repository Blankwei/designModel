package com.savoidage.designmodel.status.example;

/**
 * Author: created by savoidage
 * CreateTime: 2020-11-04 11:16
 * Description: 发货单状态变更控制器
 */
public class InvoiceOrderChangeStatusController {

    /**
     * 发货单状态变更
     * 1.创建编辑 -> 待审核 取消
     * 2.审核拒绝 -> 编辑、取消
     * 3.待审核 -> 审核通过、取消
     *
     * @param invoiceOrderId 发货单id
     * @param beforeStatus   变更前状态
     * @param afterStatus    变更后状态
     * @return 返回模组结果
     */
    public ResultModel changeStatus(Integer invoiceOrderId, Enum<Status> beforeStatus, Enum<Status> afterStatus) {
        // 1.创建编辑 -> 审核 取消
        if (Status.Editing.equals(beforeStatus)) {
            if (Status.Check.equals(afterStatus) || Status.cancel.equals(afterStatus)) {
                InvoiceOrderService.changeStatus(invoiceOrderId, beforeStatus, afterStatus);
                return new ResultModel("0000", "变更状态成功");
            } else {
                return new ResultModel("0001", "变更状态失败");
            }
        }
        // 2.审核拒绝 -> 编辑、取消
        if (Status.Refuse.equals(beforeStatus)) {
            if (Status.Editing.equals(afterStatus) || Status.cancel.equals(afterStatus)) {
                InvoiceOrderService.changeStatus(invoiceOrderId, beforeStatus, afterStatus);
                return new ResultModel("0000", "变更状态成功");
            } else {
                return new ResultModel("0001", "变更状态失败");
            }
        }
        // 3.待审核 -> 审核通过、取消
        if (Status.Check.equals(beforeStatus)) {
            if (Status.cancel.equals(afterStatus) || Status.Pass.equals(afterStatus)) {
                InvoiceOrderService.changeStatus(invoiceOrderId, beforeStatus, afterStatus);
                return new ResultModel("0000", "变更状态成功");
            } else {
                return new ResultModel("0001", "变更状态失败");
            }
        }
        return new ResultModel("0001", "此状态暂不能变更");
    }
}
