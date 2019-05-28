package com.smart.cloud.smartmodulesentinel;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangliang
 * @version 1.0
 * @description
 * @date 2019/5/27 14:55
 **/
@RestController
public class SentinelController {



    @GetMapping("/get")
//    @SentinelResource
    @SentinelResource(value="abc",blockHandler = "handleException1",blockHandlerClass = {ExceptionUtil.class},fallback = "next",fallbackClass = SentinelController.class)
    public String get() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        throw new RuntimeException("cs");
        return "this is success!!!";
    }

    public static String next() {
        return "this is next success!!!";
    }
}
