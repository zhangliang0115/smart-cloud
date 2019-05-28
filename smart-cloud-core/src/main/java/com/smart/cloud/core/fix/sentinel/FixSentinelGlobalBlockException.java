package com.smart.cloud.core.fix.sentinel;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.annotation.aspectj.SentinelResourceAspect;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.util.StringUtil;
import com.smart.cloud.core.api.Api;
import com.smart.cloud.core.exception.ErrorInfo;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhangliang
 * @version 1.0
 * @description sentinel 全局限流异常
 * @date 2019/5/27 17:05
 **/
@ConditionalOnClass(SentinelResourceAspect.class)
public class FixSentinelGlobalBlockException extends SentinelResourceAspect {

    @Autowired private SentinelGlobalBlockData globalBlock;

    @Bean
    @ConditionalOnMissingBean
    public SentinelGlobalBlockData globalBlock(){
        return (ex)-> Api.<String>me().error(ErrorInfo.me().message(ex.getMessage()));
    }


    @Override
    protected Object handleBlockException(ProceedingJoinPoint pjp, SentinelResource annotation, BlockException ex) throws Throwable {
        if(StringUtil.isBlank(annotation.blockHandler())){
            return globalBlock.get(ex);
        }
        return super.handleBlockException(pjp, annotation, ex);
    }
}
