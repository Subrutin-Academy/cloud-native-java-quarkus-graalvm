package com.subrutin.lingkar.catalog.web;

import org.jboss.resteasy.reactive.RestResponse;

import com.subrutin.lingkar.catalog.service.AuthService;
import com.subrutin.lingkar.catalog.web.dto.LoginRequestDTO;
import com.subrutin.lingkar.catalog.web.dto.LoginResponseDTO;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("/v1/auth")
public class AuthResource {

    private final AuthService authService;

    

    public AuthResource(AuthService authService) {
        this.authService = authService;
    }

    @POST
    @Path("login")
    public RestResponse<LoginResponseDTO> login(LoginRequestDTO dto){
        LoginResponseDTO responseDTO = authService.login(dto);
        return RestResponse.ok(responseDTO);
    }

}
