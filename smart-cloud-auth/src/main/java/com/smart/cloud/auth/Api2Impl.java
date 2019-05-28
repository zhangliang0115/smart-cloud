package com.smart.cloud.auth;

import org.apache.dubbo.config.annotation.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangliang
 * @version 1.0
 * @description impl
 * @date 2019/5/20 13:58
 **/
@SmartService
public class Api2Impl implements Api2{

    private Map<String,Object> map=new HashMap<>();

    @Override
    public Map<String,Object> get() {
        return map;
    }

    @Override
    public Map<String,Object> set(String a) {
        map.put("m1",a);
        return map;
    }
}
