package com.subrutin.lingkar.catalog.repository;

import java.util.Optional;

import com.subrutin.lingkar.catalog.domain.Book;
import com.subrutin.lingkar.catalog.domain.dto.BookQueryDTO;
import com.subrutin.lingkar.catalog.domain.dto.PageQuery;

import io.quarkus.panache.common.Page;
import io.quarkus.panache.common.Sort;

public interface BookRepository {

    public Book save(Book book);

    public Optional<Book> findBookById(Long id);

    public Optional<BookQueryDTO> findBookByIdUsingJpaProjection(Long id);

    PageQuery<BookQueryDTO> findBookListUsingJpaProjection(String bookTitle, Sort sort, Page page);   

    PageQuery<Book> findAllByTitleLikeIgnoreCase(String bookTitle, Sort sort, Page page);

    void softDeleteBookById(Long id);

}
