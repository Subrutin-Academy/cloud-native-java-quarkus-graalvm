package com.subrutin.lingkar.catalog.repository.impl;

import java.util.List;
import java.util.Optional;

import com.subrutin.lingkar.catalog.domain.Book;
import com.subrutin.lingkar.catalog.domain.dto.BookQueryDTO;
import com.subrutin.lingkar.catalog.domain.dto.PageQuery;
import com.subrutin.lingkar.catalog.repository.BookRepository;

import io.quarkus.hibernate.orm.panache.Panache;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import io.quarkus.panache.common.Page;
import io.quarkus.panache.common.Sort;
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

    @Override
    public Optional<BookQueryDTO> findBookByIdUsingJpaProjection(Long id) {
        return this.find("""
            SELECT 
            b.id, b.title, b.description, p.id, p.name
            FROM Book b 
            JOIN Publisher p ON p.id = b.publisher.id 
            WHERE b.id = ?1
        
        """, id).project(BookQueryDTO.class).firstResultOptional();
    }

    @Override
    public PageQuery<Book> findAllByTitleLikeIgnoreCase(String bookTitle, Sort sort, Page page) {
        PanacheQuery<Book> query = this.find("""
            WHERE UPPER(title) LIKE UPPER(?1)
                """, sort, bookTitle);
        List<Book> bookList = query.page(page).list();
        return new PageQuery<>(bookList, query.pageCount(), query.count());
    }

    @Override
    public PageQuery<BookQueryDTO> findBookListUsingJpaProjection(String bookTitle, Sort sort, Page page) {
        PanacheQuery<BookQueryDTO> query = this.find("""
            SELECT 
            b.id, b.title, b.description, p.id, p.name 
            FROM Book b 
            JOIN Publisher p ON p.id = b.publisher.id 
            WHERE UPPER(b.title) LIKE ?1
        
        """, sort, bookTitle.toUpperCase())
        .project(BookQueryDTO.class);
        List<BookQueryDTO> bookList = query.page(page).list();
        return new PageQuery<>(bookList, query.pageCount(), query.count());
    
    }

}
