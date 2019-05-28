package com.smart.cloud.core.exception;

public class ErrorStatus {


    //全局异常
    public static ErrorInfo PARAM_IS_NULL          =    new ErrorInfo("PARAM_IS_NULL",5001, "参数为空");
    public static ErrorInfo PARAM_NOT_CORRECT      =    new ErrorInfo("PARAM_NOT_CORRECT",5002, "参数值不正确");
    public static ErrorInfo PARAM_CONVERT_ERROR    =    new ErrorInfo("PARAM_CONVERT_ERROR",5003, "入参转化错误");
    public static ErrorInfo SYSTEM_ERROR           =    new ErrorInfo("SYSTEM_ERROR",5004, "服务异常，请联系系统管理员。");
    public static ErrorInfo TOKEN_EXPIRED          =    new ErrorInfo("TOKEN_EXPIRED",5005, "token已过期");
    public static ErrorInfo APP_EXPIRED            =    new ErrorInfo("APP_EXPIRED",5006, "应用已过期，请联系系统管理员");
    //业务异常
    public static ErrorInfo ACCOUNT_NOT_EXISTS     =    new ErrorInfo("ACCOUNT_NOT_EXISTS",1000, "账号不存在");
    public static ErrorInfo ACCOUNT_NOT_EMPTY      =    new ErrorInfo("ACCOUNT_NOT_EMPTY",1001, "账号或密码不能为空");
    public static ErrorInfo LOGIN_ERROR            =    new ErrorInfo("LOGIN_ERROR",1002, "账号或密码错误");
    public static ErrorInfo ACCOUNT_AUTHING        =    new ErrorInfo("ACCOUNT_AUTHING",1003, "账号审核中");
    public static ErrorInfo ACCOUNT_AUTH_FAIL      =    new ErrorInfo("ACCOUNT_AUTH_FAIL",1004, "账号审核未通过");
    public static ErrorInfo ACCOUNT_DISABLE        =    new ErrorInfo("ACCOUNT_DISABLE",1005, "账号被禁用");
    public static ErrorInfo DATA_CHANGE            =    new ErrorInfo("DATA_CHANGE",1006, "数据发生变化,请重新请求数据操作");


}
