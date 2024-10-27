package com.subrutin.configdemo.service;

import org.junit.jupiter.api.Test;

import com.subrutin.configdemo.service.EmailService;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;

@QuarkusTest
public class EmailServiceTest {

    @Inject
    EmailService emailService;

    @Test
    void testSendMail() throws Exception {
        emailService.sendMail("to@gmail.com", "Email from Quarkus", "Hello from Quarkus");
    }
}
