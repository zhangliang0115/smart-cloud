package com.smart.cloud.test.account;

import com.smart.cloud.smart.module.account.service.AccountService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangliang
 * @version 1.0
 * @description
 * @date 2019/5/23 16:28
 **/
@RestController
public class TestAccountController {
    @Reference
    AccountService accountService;

    @GetMapping("/get")
    public Object get(){
        return accountService.get();
    }

    @PostMapping("/save")
    public boolean  save(String name){
        return accountService.save(name);
    }
}
