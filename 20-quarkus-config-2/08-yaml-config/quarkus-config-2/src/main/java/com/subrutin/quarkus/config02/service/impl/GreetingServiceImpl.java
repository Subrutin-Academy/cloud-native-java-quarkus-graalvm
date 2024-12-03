package com.subrutin.quarkus.config02.service.impl;

import com.subrutin.quarkus.config02.config.ApplicationProperties;
import com.subrutin.quarkus.config02.service.GreetingService;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GreetingServiceImpl implements GreetingService {

    private final ApplicationProperties properties;

    public GreetingServiceImpl(ApplicationProperties properties) {
        this.properties = properties;
    }

    @Override
    public String sayHi() {
        return "Hi."+properties.message();
    }
}
