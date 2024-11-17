package com.subrutin.quarkuscore02.service.impl;

import com.subrutin.quarkuscore02.service.GreetingService;
import jakarta.annotation.Priority;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Alternative;

@Alternative
@Priority(10)
@ApplicationScoped
public class IndonesianGreetingServiceImpl implements GreetingService {
    @Override
    public String sayHi() {
        return "Selamat Pagi, Quarkus!";
    }
}
