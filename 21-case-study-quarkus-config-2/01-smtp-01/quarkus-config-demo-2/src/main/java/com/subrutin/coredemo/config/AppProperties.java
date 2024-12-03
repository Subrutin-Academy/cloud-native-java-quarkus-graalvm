package com.subrutin.coredemo.config;

import io.smallrye.config.ConfigMapping;

@ConfigMapping(prefix = "app")
public interface AppProperties {

    public String mailProvider();
}
