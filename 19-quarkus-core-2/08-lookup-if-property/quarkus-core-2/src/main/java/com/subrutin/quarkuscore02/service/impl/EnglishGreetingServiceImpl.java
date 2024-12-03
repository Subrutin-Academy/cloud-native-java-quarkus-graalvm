package com.subrutin.quarkuscore02.service.impl;

import com.subrutin.quarkuscore02.service.GreetingService;
import io.quarkus.arc.DefaultBean;
import io.quarkus.arc.lookup.LookupIfProperty;
import jakarta.enterprise.context.ApplicationScoped;

@LookupIfProperty(name = "app.language", stringValue = "en")
@ApplicationScoped
public class EnglishGreetingServiceImpl implements GreetingService {

    @Override
    public String sayHi() {
        return "Good Morning, Quarkus!";
    }
}
