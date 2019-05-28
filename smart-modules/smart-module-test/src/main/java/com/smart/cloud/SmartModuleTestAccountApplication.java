package com.smart.cloud;

import org.apache.dubbo.config.ApplicationConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SmartModuleTestAccountApplication {


    public static void main(String[] args) {
        new SpringApplicationBuilder(SmartModuleTestAccountApplication.class)
               .run(args);
    }

    @Autowired
    ApplicationConfig applicationConfig;

    @Bean
    public ApplicationRunner run(){
        return args -> {
            System.out.println(applicationConfig);
        };
    }


}


