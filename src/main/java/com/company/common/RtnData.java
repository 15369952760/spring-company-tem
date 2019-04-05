package com.company.common;


/**
 * @Author: yuandh
 * @Description: 结果返回
 * @Date: Created in 10:05 2019/4/3
 * @Modified By:
 */
public class RtnData<T> {

    private String code = RtnConstants.RTN_CODE_SUCCESS;
    private String message = "success";
    private T data;
    private String status = RtnConstants.RTN_STATUS_SUCCESS;

    public static RtnData ok(Object result){
        RtnData rtnData = new RtnData();
        rtnData.setCode(RtnConstants.RTN_CODE_SUCCESS);
        rtnData.setStatus(RtnConstants.RTN_STATUS_SUCCESS);
        rtnData.setData(result);
        return rtnData;
    }

    public static RtnData ok(Object result, String message){
        RtnData rtnData = new RtnData();
        rtnData.setCode(RtnConstants.RTN_CODE_SUCCESS);
        rtnData.setStatus(RtnConstants.RTN_STATUS_SUCCESS);
        rtnData.setData(result);
        rtnData.setMessage(message);
        return rtnData;
    }

    public static RtnData fail(String result){
        RtnData rtnData = new RtnData();
        rtnData.setCode(RtnConstants.RTN_CODE_FAIL);
        rtnData.setStatus(RtnConstants.RTN_STATUS_ERROR);
        rtnData.setMessage(result);
        return rtnData;
    }

    public static RtnData fail(Object result){
        return fail(result, null);
    }

    public static RtnData fail(Object result, String code, String message){
        RtnData rtnData = new RtnData();
        rtnData.setCode(code);
        rtnData.setMessage(message);
        rtnData.setStatus(RtnConstants.RTN_STATUS_ERROR);
        rtnData.setData(result);
        return rtnData;
    }

    public static RtnData fail(Object result, String message){
        return fail(result, RtnConstants.RTN_CODE_FAIL, message);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
