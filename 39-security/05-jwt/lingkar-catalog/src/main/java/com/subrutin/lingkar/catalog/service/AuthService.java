package com.subrutin.lingkar.catalog.service;

import com.subrutin.lingkar.catalog.web.dto.LoginRequestDTO;
import com.subrutin.lingkar.catalog.web.dto.LoginResponseDTO;

public interface AuthService {

    public LoginResponseDTO login(LoginRequestDTO dto);

}
