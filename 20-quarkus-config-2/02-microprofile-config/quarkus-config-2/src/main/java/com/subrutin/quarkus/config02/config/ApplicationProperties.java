package com.subrutin.quarkus.config02.config;

import io.smallrye.config.ConfigMapping;

@ConfigMapping(prefix = "app")
public interface ApplicationProperties {
    public String message();
}
