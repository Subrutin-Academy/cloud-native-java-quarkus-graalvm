package com.subrutin.lingkar.catalog.repository;

import org.junit.jupiter.api.Test;

import com.subrutin.lingkar.catalog.domain.AppUser;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;

@QuarkusTest
@TestTransaction
public class AppUserRepositoryTest {

    @Inject
    AppUserRepository appUserRepository;

    @Test
    void testSave() {
        AppUser appUser = new AppUser();
        appUser.setName("Tedy");
        appUser.setEmail("tedy@saputro.dev");
        appUser.setMobileNumber("08123456789");

        appUserRepository.save(appUser);
    }
}
