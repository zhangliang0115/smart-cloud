package com.smart.cloud.auth;

import com.sca.example.sca.api.User;
import com.sca.example.sca.api.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

//@RestController
public class ConsumerController {

    @Reference(version = "1.0.0")
    UserService userService;

    @GetMapping("/save")
    public boolean save(){
        User user = new User();
        user.setAge(100);
        user.setId(1L);
        boolean save = userService.save(user);
        return save;
    }

    @GetMapping("/find")
    public Collection<User> find(){
        Collection<User> all = userService.findAll();
        return all;
    }
}
