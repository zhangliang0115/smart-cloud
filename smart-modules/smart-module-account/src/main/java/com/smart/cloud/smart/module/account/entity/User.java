package com.smart.cloud.smart.module.account.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author zhangliang
 * @version 1.0
 * @description
 * @date 2019/5/23 16:03
 **/
@Data
public class User {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String nickName;
}
