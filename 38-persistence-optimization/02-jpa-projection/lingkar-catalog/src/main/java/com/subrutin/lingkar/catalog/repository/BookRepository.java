package com.subrutin.lingkar.catalog.repository;

import java.util.Optional;

import com.subrutin.lingkar.catalog.domain.Book;
import com.subrutin.lingkar.catalog.domain.dto.BookQueryDTO;

public interface BookRepository {

    public Book save(Book book);

    public Optional<Book> findBookById(Long id);

    public Optional<BookQueryDTO> findBookByIdUsingJpaProjection(Long id);

    void softDeleteBookById(Long id);

}
