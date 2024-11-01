package com.subrutin.coredemo.config;

import io.smallrye.config.ConfigMapping;

@ConfigMapping(prefix = "app.mail.smtp")
public interface SmtpProperties {

    Boolean auth();

    Boolean startTlsEnable();

    String host();

    Integer port();

    String username();

    String password();
    
}
