package com.subrutin.quarkuscore02.service.impl;

import com.subrutin.quarkuscore02.annotation.English;
import com.subrutin.quarkuscore02.service.GreetingService;
import jakarta.enterprise.context.ApplicationScoped;

@English
@ApplicationScoped
public class EnglishGreetingServiceImpl implements GreetingService {

    @Override
    public String sayHi() {
        return "Good Morning, Quarkus!";
    }
}
