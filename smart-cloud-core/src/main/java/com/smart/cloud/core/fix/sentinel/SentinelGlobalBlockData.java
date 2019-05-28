package com.smart.cloud.core.fix.sentinel;

import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * @author zhangliang
 * @version 1.0
 * @description
 * @date 2019/5/27 19:14
 **/
@FunctionalInterface
public interface SentinelGlobalBlockData {
    Object get(BlockException ex);
}
