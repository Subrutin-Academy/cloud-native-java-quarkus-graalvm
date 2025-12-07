package com.subrutin.lingkar.catalog.service.impl;

import java.time.Instant;

import com.subrutin.lingkar.catalog.domain.AppUser;
import com.subrutin.lingkar.catalog.service.AppUserService;
import com.subrutin.lingkar.catalog.service.AuthService;
import com.subrutin.lingkar.catalog.web.dto.LoginRequestDTO;
import com.subrutin.lingkar.catalog.web.dto.LoginResponseDTO;

import io.smallrye.jwt.build.Jwt;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AuthServiceImpl implements AuthService{

    private final AppUserService appUserService;

    

    public AuthServiceImpl(AppUserService appUserService) {
        this.appUserService = appUserService;
    }



    @Override
    public LoginResponseDTO login(LoginRequestDTO dto) {
        AppUser appUser= appUserService.authenticateUser(dto.username(), dto.password());
        //generate token jwt
        Instant exp =Instant.now().plusSeconds(900);
        String token= Jwt.issuer("https://subrutin.com")
            .subject(appUser.getUsername())
            .groups(appUser.getRole().name())
            .expiresAt(exp)
            .sign();

        return new LoginResponseDTO(appUser.getUsername(), token);
    }

}
