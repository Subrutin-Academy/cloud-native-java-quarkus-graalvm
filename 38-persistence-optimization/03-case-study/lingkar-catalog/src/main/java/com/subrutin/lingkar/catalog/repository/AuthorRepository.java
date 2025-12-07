package com.subrutin.lingkar.catalog.repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.subrutin.lingkar.catalog.domain.Author;
import com.subrutin.lingkar.catalog.domain.dto.AuthorQueryDTO;

public interface AuthorRepository {

    public void save(Author author);

    public Optional<Author> findAuthorById(Long id);

    public List<Author> findAuthorsByName(String authorName);

    public void delete(Long id);

    public List<Author> findAuthorsByIdIn(List<Long> authorIds);

	public Set<AuthorQueryDTO> findAuthorsByBookIdSet(Set<Long> bookIdSet);

}
