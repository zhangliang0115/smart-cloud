package com.smart.cloud.auth;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.lang.annotation.*;

/**
 * @author zhangliang
 * @version 1.0
 * @description 1
 * @date 2019/5/20 21:24
 **/
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Service
public @interface SmartService {
}
