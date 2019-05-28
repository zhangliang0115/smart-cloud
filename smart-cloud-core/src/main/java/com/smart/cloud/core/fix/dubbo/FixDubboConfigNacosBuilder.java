package com.smart.cloud.core.fix.dubbo;

import org.apache.dubbo.common.utils.ConfigUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.ConfigurableEnvironment;

import javax.annotation.PostConstruct;
import java.util.SortedMap;

import static org.apache.dubbo.spring.boot.util.DubboUtils.*;

/**
 * @author zhangliang
 * @version 1.0
 * @see FixDubboConfigNacosAutoConfiguration
 * @date 2019/5/23 10:24
 **/

public class FixDubboConfigNacosBuilder {

    private final ConfigurableEnvironment environment;

    public FixDubboConfigNacosBuilder(ConfigurableEnvironment environment) {
        this.environment = environment;
    }

    @PostConstruct
    public void config() {
        final Logger logger = LoggerFactory.getLogger(getClass());

        boolean override = environment.getProperty(OVERRIDE_CONFIG_FULL_PROPERTY_NAME, boolean.class,
                DEFAULT_OVERRIDE_CONFIG_PROPERTY_VALUE);

        if (override) {
            SortedMap<String, Object> dubboProperties = filterDubboProperties(environment);

            ConfigUtils.getProperties().putAll(dubboProperties);

            if (logger.isInfoEnabled()) {
                logger.info("Dubbo Config was overridden by externalized configuration {}", dubboProperties);
            }
        } else {
            if (logger.isInfoEnabled()) {
                logger.info("Disable override Dubbo Config caused by property {} = {}", OVERRIDE_CONFIG_FULL_PROPERTY_NAME, override);
            }
        }
    }
}
