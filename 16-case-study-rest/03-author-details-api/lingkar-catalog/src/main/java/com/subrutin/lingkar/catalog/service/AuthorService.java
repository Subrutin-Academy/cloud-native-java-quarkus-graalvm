package com.subrutin.lingkar.catalog.service;

import com.subrutin.lingkar.catalog.web.dto.AuthorCreateRequestDTO;
import com.subrutin.lingkar.catalog.web.dto.AuthorDetailResponseDTO;

public interface AuthorService {

    public void createAuthor(AuthorCreateRequestDTO dto);

    public AuthorDetailResponseDTO findAuthorDetail(Long authorId);
}
