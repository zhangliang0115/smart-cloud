package com.smart.cloud.core.fix.dubbo;

import com.smart.cloud.core.util.SmartUtils;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.alibaba.dubbo.autoconfigure.DubboMetadataAutoConfiguration;
import org.springframework.cloud.alibaba.nacos.client.NacosPropertySourceLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @author zhangliang
 * @version 1.0
 * @description 解决 Dubbo 不支持使用远程 nacos 配置文件的问题
 * @date 2019/5/23 9:03
 **/
@AutoConfigureAfter(NacosPropertySourceLocator.class)
@ConditionalOnProperty(prefix = SmartUtils.SMART_PREFIX, name = SmartUtils.FIX, matchIfMissing = true)
@ConditionalOnClass(value = {DubboMetadataAutoConfiguration.class,NacosPropertySourceLocator.class})
public class FixDubboConfigNacosAutoConfiguration {


    @Bean
    @ConditionalOnClass(value = {NacosPropertySourceLocator.class})
    public FixDubboConfigNacosBuilder fixNacosDubboPropertySourceLocator(ConfigurableEnvironment environment) {
        return new FixDubboConfigNacosBuilder(environment);
    }
}
