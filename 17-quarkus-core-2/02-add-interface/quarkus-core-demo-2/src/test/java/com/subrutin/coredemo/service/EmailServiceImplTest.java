package com.subrutin.coredemo.service;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;

@QuarkusTest
public class EmailServiceImplTest {

    @Inject
    EmailService emailService;

    @Test
    void testSendMail() throws Exception {
        emailService.sendMail("to@gmail.com", "Email from Quarkus", "Hello from Quarkus");
    }
}
