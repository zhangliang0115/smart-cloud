package com.smart.cloud.core.exception;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(fluent = true)
@RequiredArgsConstructor(staticName = "me")
public class ErrorInfo {

    private Integer code;
    private String message;


    public ErrorInfo(String phrase, Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public ErrorInfo(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
