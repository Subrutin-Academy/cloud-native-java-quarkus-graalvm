package com.subrutin.configdemo.config;

import java.util.Properties;

import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.inject.Produces;
import jakarta.mail.Authenticator;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;

@Dependent
public class AppConfig {
    
    @Produces
    public Properties mailProperties(SmtpProperties smtp){
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", smtp.auth());
        properties.put("mail.smtp.starttls.enable", smtp.startTlsEnable());
        properties.put("mail.smtp.host", smtp.host());
        properties.put("mail.smtp.port", smtp.port());
        properties.put("mail.smtp.ssl.trust", smtp.host());    
        return properties;
    }

    @Produces
    public PasswordAuthentication passwordAuthentication(SmtpProperties smtp){
        return new PasswordAuthentication(smtp.username(), smtp.password());
    }


    @Produces
    public Session mailSession(Properties mailProperties, PasswordAuthentication passwordAuthentication){
        return Session.getInstance(mailProperties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return passwordAuthentication;
            }
        });
    }
}
