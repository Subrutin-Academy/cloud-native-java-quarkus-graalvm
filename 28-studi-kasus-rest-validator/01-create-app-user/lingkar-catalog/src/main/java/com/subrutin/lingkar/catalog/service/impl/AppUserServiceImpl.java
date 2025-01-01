package com.subrutin.lingkar.catalog.service.impl;

import com.subrutin.lingkar.catalog.domain.AppUser;
import com.subrutin.lingkar.catalog.repository.AppUserRepository;
import com.subrutin.lingkar.catalog.service.AppUserService;
import com.subrutin.lingkar.catalog.web.dto.AppUserRequestDTO;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AppUserServiceImpl implements AppUserService{

    private final AppUserRepository appUserRepository;

    public AppUserServiceImpl(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }



    @Override
    public void createAppUser(AppUserRequestDTO dto) {
        AppUser appUser = new AppUser();
        appUser.setName(dto.name());
        appUser.setEmail(dto.email());
        appUser.setMobileNumber(dto.mobileNumber());
        appUserRepository.save(appUser);
    }

}
