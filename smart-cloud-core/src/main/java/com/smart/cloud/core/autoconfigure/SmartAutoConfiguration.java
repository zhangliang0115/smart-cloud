package com.smart.cloud.core.autoconfigure;

import com.smart.cloud.core.property.SmartProperties;
import com.smart.cloud.core.util.SmartUtils;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhangliang
 * @version 1.0
 * @description
 * @date 2019/5/23 14:00
 **/
@ConditionalOnProperty(prefix = SmartUtils.SMART_PREFIX, name = SmartUtils.ENABLED, matchIfMissing = true)
@Configuration
@EnableConfigurationProperties(SmartProperties.class)
public class SmartAutoConfiguration {


}
