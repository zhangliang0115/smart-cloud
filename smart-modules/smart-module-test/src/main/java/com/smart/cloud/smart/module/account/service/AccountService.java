package com.smart.cloud.smart.module.account.service;

/**
 * @author zhangliang
 * @version 1.0
 * @description 用户服务
 * @date 2019/5/23 15:58
 **/

public interface AccountService {
    boolean save(String name);

    Object get();
}
