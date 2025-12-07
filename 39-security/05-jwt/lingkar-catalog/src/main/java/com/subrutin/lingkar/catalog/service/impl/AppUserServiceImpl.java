package com.subrutin.lingkar.catalog.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.subrutin.lingkar.catalog.domain.AppUser;
import com.subrutin.lingkar.catalog.domain.Profile;
import com.subrutin.lingkar.catalog.domain.Role;
import com.subrutin.lingkar.catalog.domain.dto.PageQuery;
import com.subrutin.lingkar.catalog.exception.AuthenticationException;
import com.subrutin.lingkar.catalog.repository.AppUserRepository;
import com.subrutin.lingkar.catalog.service.AppUserService;
import com.subrutin.lingkar.catalog.util.PaginationUtil;
import com.subrutin.lingkar.catalog.web.dto.AppUserDetailResponseDTO;
import com.subrutin.lingkar.catalog.web.dto.AppUserListResponseDTO;
import com.subrutin.lingkar.catalog.web.dto.AppUserRequestDTO;
import com.subrutin.lingkar.catalog.web.dto.ResultPageResponseDTO;

import io.quarkus.elytron.security.common.BcryptUtil;
import io.quarkus.logging.Log;
import io.quarkus.panache.common.Page;
import io.quarkus.panache.common.Sort;
import io.quarkus.runtime.util.StringUtil;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

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
        appUser.setUsername(dto.username());
        appUser.setPassword(BcryptUtil.bcryptHash(dto.password()));
        appUser.setRole(Role.USER);

        Profile profile = new Profile();
        profile.setBirthDate(LocalDate.ofEpochDay(dto.profie().birthDate()));
        profile.setAddress(dto.profie().address());
        profile.setZipCode(dto.profie().zipCode());
        profile.setAppUser(appUser);

        appUser.setProfile(profile);
    
        Log.info(appUser.getPassword());

        appUserRepository.save(appUser);
    }



    @Override
    public ResultPageResponseDTO<AppUserListResponseDTO> findAppUserList(Integer pages, Integer limit, 
            String sortBy,
            String direction,
            String name) {
        name = StringUtil.isNullOrEmpty(name) ? "%" : name + "%";
        Sort sort = Sort.by(sortBy, PaginationUtil.getDirection(direction));
        Page page = Page.of(pages,limit);
        PageQuery<AppUser> pageResult= appUserRepository.findAppUserList(name, sort, page);
        List<AppUserListResponseDTO> dtoList = pageResult.result().stream().map(au->{
            return new AppUserListResponseDTO(au.getSecureId(), au.getName());
        }).collect(Collectors.toList());   
        return new ResultPageResponseDTO<>(dtoList, pageResult.pages(), pageResult.elements());     
    }



    @Override
    public AppUserDetailResponseDTO findAppUserDetail(UUID id) {
        AppUser appUser = appUserRepository.findAppUserDetail(id)
            .orElseThrow(()->new RuntimeException("appuser id not found"));
        return new AppUserDetailResponseDTO(appUser.getSecureId(), appUser.getName(), 
            appUser.getEmail(), appUser.getMobileNumber());
    }


    @Transactional
    @Override
    public void updateAppUser(UUID id, AppUserRequestDTO dto) {
        AppUser appUser = appUserRepository.findAppUserDetail(id)
        .orElseThrow(()->new RuntimeException("appuser id not found"));  
        Profile profile = appUser.getProfile();
        appUser.setName(dto.name());
        appUser.setEmail(dto.email());
        appUser.setMobileNumber(dto.mobileNumber());

        profile.setBirthDate(LocalDate.ofEpochDay(dto.profie().birthDate()));
        profile.setAddress(dto.profie().address());
        profile.setZipCode(dto.profie().zipCode());
        profile.setAppUser(appUser);

        appUser.setProfile(profile);
        appUserRepository.save(appUser);
    }



    @Override
    public void deleteAppUser(UUID id) {
       appUserRepository.hardDelete(id);
    }



    @Override
    public AppUser authenticateUser(String username, String password) {
        AppUser appUser =  appUserRepository.findByUsername(username)
            .orElseThrow(()-> new AuthenticationException("invalid username/password"));

        if(!BcryptUtil.matches(password, appUser.getPassword())){
            throw new AuthenticationException("invalid username/password");
        }
        return appUser;
    }

}
