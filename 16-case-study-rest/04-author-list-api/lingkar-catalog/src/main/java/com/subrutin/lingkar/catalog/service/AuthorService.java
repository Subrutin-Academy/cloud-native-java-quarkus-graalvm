package com.subrutin.lingkar.catalog.service;

import java.util.List;

import com.subrutin.lingkar.catalog.web.dto.AuthorCreateRequestDTO;
import com.subrutin.lingkar.catalog.web.dto.AuthorDetailResponseDTO;
import com.subrutin.lingkar.catalog.web.dto.AuthorListResponseDTO;

public interface AuthorService {

    public void createAuthor(AuthorCreateRequestDTO dto);

    public AuthorDetailResponseDTO findAuthorDetail(Long authorId);

    public List<AuthorListResponseDTO> findAuthorList(String authorName);
}
