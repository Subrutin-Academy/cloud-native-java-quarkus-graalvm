package com.subrutin.quarkuscore02.service.impl;

import com.subrutin.quarkuscore02.service.GreetingService;
import io.quarkus.arc.profile.IfBuildProfile;
import jakarta.enterprise.context.ApplicationScoped;

@IfBuildProfile("staging")
@ApplicationScoped
public class EnglishGreetingServiceImpl implements GreetingService {

    @Override
    public String sayHi() {
        return "Good Morning, Quarkus!";
    }
}
