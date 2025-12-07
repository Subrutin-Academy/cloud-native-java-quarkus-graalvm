package com.subrutin.lingkar.catalog.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;

import org.junit.jupiter.api.Test;

import com.subrutin.lingkar.catalog.domain.Book;
import com.subrutin.lingkar.catalog.domain.Category;
import com.subrutin.lingkar.catalog.domain.Publisher;
import com.subrutin.lingkar.catalog.exception.ResourceNotFoundException;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@QuarkusTest
public class BookRepositoryTest {
    
    @Inject
    BookRepository bookRepository;
    //test fetch eager book - publisher
    @Test @Transactional
    void testFetchDirectBookById() {
        Book book = bookRepository.findBookById(1L)
            .orElseThrow(() -> new ResourceNotFoundException("Book not found"));
        assertEquals("Laskar Pelangi", book.getTitle());
    }
    
    @Test @Transactional
    void testFetchBookPublisher() {
        Book book = bookRepository.findBookById(1L)
            .orElseThrow(() -> new ResourceNotFoundException("Book not found"));

        Publisher publisher = book.getPublisher();
        assertEquals("Bentang Pustaka", publisher.getName());
    }

    @Test @Transactional
    void testFetchBookCategories() {
        Book book = bookRepository.findBookById(24L)
            .orElseThrow(() -> new ResourceNotFoundException("Book not found"));

        Set<Category> categories = book.getCategories();
        assertEquals(3, categories.size());
    }
}
