package com.smart.cloud.auth;

import java.util.Map;

/**
 * @author zhangliang
 * @version 1.0
 * @description Api
 * @date 2019/5/20 13:57
 **/
public interface Api {
    Map<String,Object> get();
    Map<String,Object> set(String a);
}
