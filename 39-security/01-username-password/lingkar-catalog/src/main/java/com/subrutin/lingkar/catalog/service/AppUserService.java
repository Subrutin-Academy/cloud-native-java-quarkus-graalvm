package com.subrutin.lingkar.catalog.service;

import java.util.UUID;

import com.subrutin.lingkar.catalog.domain.AppUser;
import com.subrutin.lingkar.catalog.web.dto.AppUserDetailResponseDTO;
import com.subrutin.lingkar.catalog.web.dto.AppUserListResponseDTO;
import com.subrutin.lingkar.catalog.web.dto.AppUserRequestDTO;
import com.subrutin.lingkar.catalog.web.dto.ResultPageResponseDTO;

public interface AppUserService {

    public void createAppUser(AppUserRequestDTO dto);

    public void updateAppUser(UUID id, AppUserRequestDTO dto);

    public ResultPageResponseDTO<AppUserListResponseDTO> findAppUserList(
        Integer pages,
        Integer limit,
        String sortBy,
        String direction,
        String name
    );

    public AppUserDetailResponseDTO findAppUserDetail(UUID id);

    public void deleteAppUser(UUID id);

    public AppUser authenticateUser(String username, String password);

}
