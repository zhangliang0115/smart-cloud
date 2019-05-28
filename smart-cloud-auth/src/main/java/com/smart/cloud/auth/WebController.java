package com.smart.cloud.auth;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangliang
 * @version 1.0
 * @description cs
 * @date 2019/5/20 15:06
 **/
@RestController
public class WebController {

    @Autowired
    private Api api;

    @GetMapping("/get")
    public Object get() {
        return api.get();
    }

    @GetMapping("/set")
    public Object set(String a) {
        return api.set(a);
    }
}
