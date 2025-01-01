package com.subrutin.lingkar.catalog.web;

import java.net.URI;

import org.jboss.resteasy.reactive.RestResponse;

import com.subrutin.lingkar.catalog.service.AppUserService;
import com.subrutin.lingkar.catalog.web.dto.AppUserRequestDTO;

import jakarta.validation.Valid;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("/v1/app-user")
public class AppUserResource {

    private final AppUserService appUserService;

    

    public AppUserResource(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @POST
    public RestResponse<Void> createAppUser(@Valid AppUserRequestDTO dto){
        this.appUserService.createAppUser(dto);
        return RestResponse.created(URI.create("/v1/app-user"));
    }
}
