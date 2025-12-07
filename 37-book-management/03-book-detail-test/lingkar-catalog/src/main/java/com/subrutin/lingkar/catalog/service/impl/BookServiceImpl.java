package com.subrutin.lingkar.catalog.service.impl;

import java.util.List;
import java.util.Set;

import com.subrutin.lingkar.catalog.domain.Author;
import com.subrutin.lingkar.catalog.domain.Book;
import com.subrutin.lingkar.catalog.domain.Category;
import com.subrutin.lingkar.catalog.domain.Publisher;
import com.subrutin.lingkar.catalog.repository.BookRepository;
import com.subrutin.lingkar.catalog.service.AuthorService;
import com.subrutin.lingkar.catalog.service.BookService;
import com.subrutin.lingkar.catalog.service.CategoryService;
import com.subrutin.lingkar.catalog.service.PublisherService;
import com.subrutin.lingkar.catalog.web.dto.BookCreateRequestDTO;
import com.subrutin.lingkar.catalog.web.dto.IdResponseDTO;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class BookServiceImpl implements BookService {

    private final AuthorService authorService;

    private final CategoryService categoryService;

    private final PublisherService publisherService;

    private final BookRepository bookRepository;

    public BookServiceImpl(AuthorService authorService, CategoryService categoryService,
        PublisherService publisherService, BookRepository bookRepository) {
        this.authorService = authorService;
        this.categoryService = categoryService;
        this.publisherService = publisherService;
        this.bookRepository = bookRepository;
    }


    @Transactional
    @Override
    public IdResponseDTO createBook(BookCreateRequestDTO dto) {
        //1.find authorList by AuthorId
        Set<Author> authors =  authorService.findAllAuthors(dto.authorsId());
        //2. find CategoryList by categoryCode
        Set<Category> categories = categoryService.findCategories(dto.categoriesCode());
        //3. find publisher by publisherId
        Publisher publisher = publisherService.findPublisherById(dto.publisherId());
        //4. dto -> entity
        Book book = new Book();
        book.setAuthors(authors);
        book.setCategories(categories);
        book.setPublisher(publisher);
        book.setTitle(dto.title());
        book.setPages(dto.pages());
        book.setYear(dto.year());
        book.setDescription(dto.description());
        //5. save
        book = bookRepository.save(book);
        return new IdResponseDTO(book.getId());
    }

}
