package com.subrutin.lingkar.catalog.repository.impl;

import java.util.List;
import java.util.Optional;

import com.subrutin.lingkar.catalog.domain.Author;
import com.subrutin.lingkar.catalog.repository.AuthorRepository;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
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

    @Override
    public Optional<Author> findAuthorById(Long id) {
        return this.find("WHERE id=?1",id).firstResultOptional();
    }

    @Override
    public List<Author> findAuthorsByName(String authorName) {
        PanacheQuery<Author> query = this.find("WHERE UPPER(name) LIKE ?1",authorName.toUpperCase());
        return query.list();
    }

    @Transactional
    @Override
    public void delete(Long id) {
      this.deleteById(id);
    }

    @Override
    public List<Author> findAuthorsByIdIn(List<Long> authorIds) {
        //select * from author a where id in authorIds
       return this.find("WHERE id IN ?1", authorIds).list();
    }

}
