package com.subrutin.lingkar.catalog.repository;

import java.util.Optional;

import com.subrutin.lingkar.catalog.domain.Author;

public interface AuthorRepository {

    public void save(Author author);

    public Optional<Author> findAuthorById(Long id);

}
