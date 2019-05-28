package com.smart.cloud.smart.module.account;


import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.smart.cloud.smart.module.account")
public class SmartModuleAccountApplication {

    private static final Logger log = LoggerFactory.getLogger(SmartModuleAccountApplication.class);


    public static void main(String[] args) {
        new SpringApplicationBuilder(SmartModuleAccountApplication.class)
                .listeners().run(args);
        log.info("started...");
    }



}


