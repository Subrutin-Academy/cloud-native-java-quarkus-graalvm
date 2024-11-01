package com.subrutin.coredemo.service.impl;

import com.subrutin.coredemo.service.AuthService;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class AuthServiceImplTest {

    @Inject
    AuthService authService;

    @Test
    void login() throws Exception {
        authService.login("test@gmail.com");
    }
}