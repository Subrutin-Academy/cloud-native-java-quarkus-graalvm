package com.subrutin.quarkuscore02.service.impl;

import com.subrutin.quarkuscore02.annotation.Indonesian;
import com.subrutin.quarkuscore02.service.GreetingService;
import jakarta.enterprise.context.ApplicationScoped;

@Indonesian
@ApplicationScoped
public class IndonesianGreetingServiceImpl implements GreetingService {
    @Override
    public String sayHi() {
        return "Selamat Pagi, Quarkus!";
    }
}
