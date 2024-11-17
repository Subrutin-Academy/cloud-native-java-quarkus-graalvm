package com.subrutin.coredemo.service;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;

@QuarkusTest
public class EmailServiceTest {
    
    @Inject
    EmailService emailService;

    @Test
    void testSendMail() {
        try {
            emailService.sendMail("to@gmail.com", "Quarkus Mail", "send from quarkus project");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
