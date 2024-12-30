package com.subrutin.lingkar.catalog.repository;

import java.util.List;
import java.util.Optional;

import com.subrutin.lingkar.catalog.domain.Author;

public interface AuthorRepository {

    public void save(Author author);

    public Optional<Author> findAuthorById(Long id);

    public List<Author> findAuthorsByName(String authorName);

    public void delete(Long id);

}
