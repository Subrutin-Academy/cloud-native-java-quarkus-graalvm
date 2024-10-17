package com.subrutin.coredemo.config;

import java.util.Properties;

import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.inject.Produces;
import jakarta.mail.Authenticator;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;

@Dependent
public class AppConfig {
    
    @Produces
    public Properties mailProperties(){
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", true);
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "sandbox.smtp.mailtrap.io");
        properties.put("mail.smtp.port", 2525);
        properties.put("mail.smtp.ssl.trust", "sandbox.smtp.mailtrap.io");    
        return properties;
    }

    @Produces
    public PasswordAuthentication passwordAuthentication(){
        return new PasswordAuthentication("5a4e7ff71d5bac", "8d6ee301389b31");
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
