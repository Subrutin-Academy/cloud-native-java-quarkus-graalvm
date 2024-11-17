package com.subrutin.coredemo.service;

public interface AuthService {

    public Boolean login(String email) throws Exception;

    public Boolean confirmOTP(String session, String otp);
}
