package com.subrutin.coredemo.web;

import org.jboss.resteasy.reactive.RestResponse;

import com.subrutin.coredemo.service.EmailService;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("/v1/email")
public class EmaiLResource {

    private final EmailService emailService;



    public EmaiLResource(EmailService emailService) {
        this.emailService = emailService;
    }



    @POST
    public RestResponse<Void> sendMail() throws Exception{
        emailService.sendMail("to@gmail.com", "Quarkus Mail", "send from quarkus project");
        return RestResponse.ok();
    }
}
