package com.smart.cloud.core.property;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author zhangliang
 * @version 1.0
 * @description
 * @date 2019/5/23 11:15
 **/
@Component
@ConfigurationProperties(prefix = "smart")
public class SmartProperties {

    private boolean fix;

    private boolean enabled;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }


    public boolean isFix() {
        return fix;
    }

    public void setFix(boolean fix) {
        this.fix = fix;
    }
}
