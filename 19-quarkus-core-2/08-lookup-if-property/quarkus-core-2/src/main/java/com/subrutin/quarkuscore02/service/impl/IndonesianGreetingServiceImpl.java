package com.subrutin.quarkuscore02.service.impl;

import com.subrutin.quarkuscore02.service.GreetingService;
import io.quarkus.arc.lookup.LookupIfProperty;
import jakarta.enterprise.context.ApplicationScoped;

@LookupIfProperty(name = "app.language", stringValue = "id")
@ApplicationScoped
public class IndonesianGreetingServiceImpl implements GreetingService {
    @Override
    public String sayHi() {
        return "Selamat Pagi, Quarkus!";
    }
}
