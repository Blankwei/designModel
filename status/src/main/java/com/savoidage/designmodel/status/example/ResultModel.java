package com.savoidage.designmodel.status.example;

/**
 * Author: created by savoidage
 * CreateTime: 2020-11-04 11:10
 * Description: 结果模组
 */
public class ResultModel {

    // 状态码
    private String code;

    // 状态描述
    private String message;

    public ResultModel(String code,String message){
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code == null ? "" : code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message == null ? "" : message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
