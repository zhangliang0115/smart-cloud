package com.smart.cloud.gateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author zhangliang
 * @version 1.0
 * @description 测试类
 * @date 2019/5/20 13:12
 **/
@RefreshScope
@RestController
public class WebController {



    @Autowired
    private Map<String,String> getName;




    @GetMapping("/get")
    public Object get(){
        return getName;
    }


}
