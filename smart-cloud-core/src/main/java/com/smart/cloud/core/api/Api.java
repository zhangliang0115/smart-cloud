package com.smart.cloud.core.api;

import com.smart.cloud.core.exception.ErrorInfo;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 *@ClassName Api
 *@Description 接口返回的包装类
 *@Author zhangliang
 *@Date 2019/4/16  15:32
 *@Version 1.0
 **/
@Data
@Accessors(fluent =true)
@RequiredArgsConstructor(staticName = "me")
public class Api<T> {
    /**是否成功*/
    private boolean success=true;

    /**请求路径*/
    private String path;

    /**当前系统时间*/
    private Date timestamp;

    /**数据体*/
    private T data;

    /**错误信息*/
    private ErrorInfo error;
}
