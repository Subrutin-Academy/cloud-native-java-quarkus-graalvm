package com.subrutin.quarkuscore02.service.impl;

import com.subrutin.quarkuscore02.service.GreetingService;
import jakarta.annotation.Priority;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Alternative;

@Alternative
@Priority(2)
@ApplicationScoped
public class EnglishGreetingServiceImpl implements GreetingService {

    @Override
    public String sayHi() {
        return "Good Morning, Quarkus!";
    }
}
