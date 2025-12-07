package com.subrutin.lingkar.catalog.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.subrutin.lingkar.catalog.web.dto.AuthorRequestDTO;
import com.subrutin.lingkar.catalog.domain.Author;
import com.subrutin.lingkar.catalog.web.dto.AuthorDetailResponseDTO;
import com.subrutin.lingkar.catalog.web.dto.AuthorListResponseDTO;

public interface AuthorService {

    public void createAuthor(AuthorRequestDTO dto);

    public AuthorDetailResponseDTO findAuthorDetail(Long authorId);

    public List<AuthorListResponseDTO> findAuthorList(String authorName);

    public Set<Author> findAllAuthors(List<Long> authorIds);

    public void updateAuthor(Long id, AuthorRequestDTO dto);

    public void delete(Long id);

	public Map<Long, Set<AuthorListResponseDTO>> findAuthorMap(Set<Long> bookIdSet);

}
