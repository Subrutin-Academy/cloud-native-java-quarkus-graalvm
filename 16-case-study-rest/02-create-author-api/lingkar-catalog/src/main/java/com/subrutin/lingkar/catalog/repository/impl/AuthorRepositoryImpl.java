package com.subrutin.lingkar.catalog.repository.impl;

import com.subrutin.lingkar.catalog.domain.Author;
import com.subrutin.lingkar.catalog.repository.AuthorRepository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class AuthorRepositoryImpl implements AuthorRepository, PanacheRepositoryBase<Author, Long> {

    @Transactional
    @Override
    public void save(Author author) {
        this.persist(author);
    }

}
