package com.smart.cloud.core.fix.dubbo;

import com.smart.cloud.core.util.SmartUtils;
import org.apache.dubbo.config.ApplicationConfig;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * @author zhangliang
 * @version 1.0
 * @description 解决 Dubbo 默认关不闭 qos
 * @date 2019/5/23 9:03
 **/
@ConditionalOnProperty(prefix = SmartUtils.SMART_PREFIX, name = SmartUtils.FIX, matchIfMissing = true)
@ConditionalOnClass(value = {ApplicationConfig.class})
public class FixDubboConfigAutoConfiguration {


    /**
     * 默认关闭 qos
     *
     * @return
     */
    @Bean
    @ConfigurationProperties(prefix = "smart.dubbo")
    @ConditionalOnMissingBean(ApplicationConfig.class)
    public ApplicationConfig applicationConfig() {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setQosEnable(false);
        System.out.println("=======================");
        return applicationConfig;
    }


}
