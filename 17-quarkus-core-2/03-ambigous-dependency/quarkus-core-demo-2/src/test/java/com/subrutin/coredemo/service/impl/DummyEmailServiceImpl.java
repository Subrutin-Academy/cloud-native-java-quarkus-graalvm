package com.subrutin.coredemo.service.impl;

import com.subrutin.coredemo.service.EmailService;
import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Default;

@ApplicationScoped
public class DummyEmailServiceImpl implements EmailService {

    @Override
    public void sendMail(String destinationAddress, String mailSubject, String messageContent) throws Exception {
        Log.info("destination address:"+destinationAddress);
        Log.info("Mail Subject:"+mailSubject);
        Log.info("Content:"+messageContent);

    }
}
