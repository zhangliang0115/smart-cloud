package com.smart.cloud.auth;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangliang
 * @version 1.0
 * @description impl
 * @date 2019/5/20 13:58
 **/
@Service(version = "1.0.0", protocol = {"dubbo"})
@SmartService
public class ApiImpl implements Api{

    private Map<String,Object> map=new HashMap<>();

    @Autowired
    private Api2 api2;

    @Override
    public Map<String,Object> get() {
        return map;
    }

    @Override
    public Map<String,Object> set(String a) {
        map.put("m",a);
        api2.set(a);
        map.putAll(api2.get());
        return map;
    }
}
