package com.subrutin.quarkuscore02.service.impl;

import com.subrutin.quarkuscore02.service.GreetingService;
import io.quarkus.arc.properties.IfBuildProperty;
import jakarta.enterprise.context.ApplicationScoped;

@IfBuildProperty(name = "app.language", stringValue = "id")
@ApplicationScoped
public class IndonesianGreetingServiceImpl implements GreetingService {
    @Override
    public String sayHi() {
        return "Selamat Pagi, Quarkus!";
    }
}
