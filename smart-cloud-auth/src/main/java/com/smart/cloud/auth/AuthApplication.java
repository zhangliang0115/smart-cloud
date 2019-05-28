package com.smart.cloud.auth;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author zhangliang
 * @version 1.0
 * @description 鉴权服务
 * @date 2019/5/20 13:53
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class AuthApplication {


    public static void main(String[] args) {
        new SpringApplicationBuilder(AuthApplication.class)
                .run(args);
    }
}
