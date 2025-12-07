package com.subrutin.lingkar.catalog.repository.impl;

import java.util.Optional;

import com.subrutin.lingkar.catalog.domain.Book;
import com.subrutin.lingkar.catalog.repository.BookRepository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class BookRepositoryImpl implements BookRepository, PanacheRepositoryBase<Book, Long> {

    @Transactional
    @Override
    public Book save(Book book) {
  
        this.persist(book);
        return book;
    }

    @Override
    public Optional<Book> findBookById(Long id) {
       return this.findByIdOptional(id);
    }

    @Transactional
    @Override
    public void softDeleteBookById(Long id) {
       this.update("SET deleted = true WHERE id = ?1",id);
    }

}
