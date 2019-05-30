package com.smart.cloud.smart.module.account.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.smart.cloud.smart.module.account.entity.User;
import com.smart.cloud.smart.module.account.mapper.UserMapper;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author zhangliang
 * @version 1.0
 * @description
 * @date 2019/5/23 15:59
 **/
@Service(protocol = {"dubbo","rest"})
public class AccountServiceImpl extends ServiceImpl<UserMapper, User> implements AccountService {

    @Override
    public boolean save(String name) {
        User user = new User();
        user.setNickName(name);
        boolean b = super.saveOrUpdate(user);
        return b;
    }

    @Override
    public Object get() {
        return listMaps();
    }
}
