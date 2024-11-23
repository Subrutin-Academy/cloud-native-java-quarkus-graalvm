package com.subrutin.quarkus.config02.service;

import com.subrutin.quarkus.config02.config.ApplicationProperties;
import jakarta.enterprise.context.ApplicationScoped;

public interface GreetingService {

    public String sayHi();
}
