package org.example.managebook.model;

import lombok.Data;
import org.example.managebook.constant.ResultStatus;

@Data
public class Result <T>{
    private ResultStatus code;
    private String errorMsg;
    private T data;

    public static <T> Result success(T data) {
        Result result = new Result();
        result.setCode(ResultStatus.SUCCESS);
        result.setData(data);
        return result;
    }

    public static Result noLogin() {
        Result result = new Result<>();
        result.setCode(ResultStatus.NOLOGIN);
        result.setErrorMsg("用户未登录");
        result.setData(null);
        return result;
    }

    public static Result fail(ResultStatus resultStatus,String errorMsg) {
        Result result = new Result<>();
        result.setCode(resultStatus);
        result.setErrorMsg(errorMsg);
        result.setData(null);
        return result;
    }
}
