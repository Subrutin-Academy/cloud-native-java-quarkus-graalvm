package com.subrutin.quarkuscore02.service.impl;

import com.subrutin.quarkuscore02.service.GreetingService;
import io.quarkus.arc.DefaultBean;
import jakarta.enterprise.context.ApplicationScoped;

@DefaultBean
@ApplicationScoped
public class EnglishGreetingServiceImpl implements GreetingService {

    @Override
    public String sayHi() {
        return "Good Morning, Quarkus!";
    }
}
