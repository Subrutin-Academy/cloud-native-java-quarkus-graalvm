package com.subrutin.coredemo.service.impl;

import com.subrutin.coredemo.service.AuthService;
import com.subrutin.coredemo.service.EmailService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Default;

@ApplicationScoped
public class AuthServiceImpl implements AuthService {

    private final EmailService emailService;

    public AuthServiceImpl(EmailService emailService) {
        this.emailService = emailService;
    }

    @Override
    public Boolean login(String email) throws Exception {
        //
        emailService.sendMail(email, "Your OTP","123456");
        return Boolean.TRUE;
    }

    @Override
    public Boolean confirmOTP(String session, String otp) {
        return null;
    }
}
