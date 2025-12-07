package com.subrutin.lingkar.catalog.repository;

import java.util.Optional;

import com.subrutin.lingkar.catalog.domain.Book;

public interface BookRepository {

    public Book save(Book book);

    public Optional<Book> findBookById(Long id);

}
