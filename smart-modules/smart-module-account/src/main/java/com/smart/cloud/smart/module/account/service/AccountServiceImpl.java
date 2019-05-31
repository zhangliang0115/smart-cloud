package com.smart.cloud.smart.module.account.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.smart.cloud.smart.module.account.entity.User;
import com.smart.cloud.smart.module.account.mapper.UserMapper;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangliang
 * @version 1.0
 * @description
 * @date 2019/5/23 15:59
 **/
@Service(protocol = {"dubbo"})
@RestController
public class AccountServiceImpl extends ServiceImpl<UserMapper, User> implements AccountService {


    private Integer port;

    @EventListener(WebServerInitializedEvent.class)
    public void onApplicationEvent(WebServerInitializedEvent event) {
        port=event.getWebServer().getPort();
        System.out.println(event.getWebServer().getPort());
    }

    @Override
    @GetMapping("/save")
    public boolean save(@RequestParam String name) {
        User user = new User();
        user.setNickName(name);
        boolean b = super.saveOrUpdate(user);
        return b;
    }

    @Override
    @GetMapping("/get")
    public Object get() {
        System.out.println("port:"+port);
        return listMaps();
    }
}
