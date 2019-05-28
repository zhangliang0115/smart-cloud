package com.smart.cloud.gateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangliang
 * @version 1.0
 * @description 网关启动类
 * @date 2019/5/20 12:58
 **/
@SpringBootApplication
@EnableDiscoveryClient
@RefreshScope
public class GatewayApplication {

    @Value("${smart.cloud.name}")
    private String name;


    @Bean
    @RefreshScope
    public Map<String,String> getName(){
        Map<String,String> map=new HashMap<>();
        map.put("name",name);
       return  map;
   }




    public static void main(String[] args) {
    		new SpringApplicationBuilder(GatewayApplication.class)
                    .run(args);

    }
}
