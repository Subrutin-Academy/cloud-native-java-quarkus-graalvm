package com.subrutin.lingkar.catalog.repository.impl;

import com.subrutin.lingkar.catalog.domain.AppUser;
import com.subrutin.lingkar.catalog.repository.AppUserRepository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AppUserRepositoryImpl implements AppUserRepository, PanacheRepositoryBase<AppUser, Long> {

    @Override
    public void save(AppUser appUser) {
        this.persist(appUser);
    }

}
