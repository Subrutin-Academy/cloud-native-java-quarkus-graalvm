package com.subrutin.lingkar.catalog.service.impl;

import com.subrutin.lingkar.catalog.domain.AppUser;
import com.subrutin.lingkar.catalog.service.AppUserService;
import com.subrutin.lingkar.catalog.service.AuthService;
import com.subrutin.lingkar.catalog.web.dto.LoginRequestDTO;
import com.subrutin.lingkar.catalog.web.dto.LoginResponseDTO;

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

        return new LoginResponseDTO(appUser.getUsername(), null);
    }

}
