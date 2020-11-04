package com.savoidage.designmodel.status.example;

import com.savoidage.designmodel.status.example.impl.CheckState;
import com.savoidage.designmodel.status.example.impl.EditingState;
import com.savoidage.designmodel.status.example.impl.PassState;
import com.savoidage.designmodel.status.example.impl.RefuseState;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Author: created by savoidage
 * CreateTime: 2020-11-04 14:03
 * Description: 状态流转处理器
 */
public class StateHandler {

    private Map<Enum<Status>,State> stateMap = new ConcurrentHashMap<>();

    public StateHandler(){
        stateMap.put(Status.Editing,new EditingState()); // 创建/编辑
        stateMap.put(Status.Check,new CheckState()); // 待审核
        stateMap.put(Status.Pass,new PassState()); // 审核通过
        stateMap.put(Status.Refuse,new RefuseState()); // 审核被拒绝
    }

    public ResultModel editCheck(Integer invoiceOrderId, Enum<Status> currentStatus) {
        return stateMap.get(currentStatus).editCheck(invoiceOrderId,currentStatus);
    }

    public ResultModel editCancel(Integer invoiceOrderId, Enum<Status> currentStatus) {
        return stateMap.get(currentStatus).editCancel(invoiceOrderId,currentStatus);
    }

    public ResultModel checkPass(Integer invoiceOrderId, Enum<Status> currentStatus) {
        return stateMap.get(currentStatus).checkPass(invoiceOrderId,currentStatus);
    }

    public ResultModel checkRefuse(Integer invoiceOrderId, Enum<Status> currentStatus) {
        return stateMap.get(currentStatus).checkRefuse(invoiceOrderId,currentStatus);
    }

    public ResultModel passCancel(Integer invoiceOrderId, Enum<Status> currentStatus) {
        return stateMap.get(currentStatus).passCancel(invoiceOrderId,currentStatus);
    }

    public ResultModel refuseCancel(Integer invoiceOrderId, Enum<Status> currentStatus) {
        return stateMap.get(currentStatus).refuseCancel(invoiceOrderId,currentStatus);
    }
}
