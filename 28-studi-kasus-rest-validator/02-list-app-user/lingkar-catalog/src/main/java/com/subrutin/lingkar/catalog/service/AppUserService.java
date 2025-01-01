package com.subrutin.lingkar.catalog.service;

import com.subrutin.lingkar.catalog.web.dto.AppUserListResponseDTO;
import com.subrutin.lingkar.catalog.web.dto.AppUserRequestDTO;
import com.subrutin.lingkar.catalog.web.dto.ResultPageResponseDTO;

public interface AppUserService {

    public void createAppUser(AppUserRequestDTO dto);

    public ResultPageResponseDTO<AppUserListResponseDTO> findAppUserList(
        Integer pages,
        Integer limit,
        String sortBy,
        String direction,
        String name
    );

}