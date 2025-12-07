package com.subrutin.lingkar.catalog.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.subrutin.lingkar.catalog.domain.Author;
import com.subrutin.lingkar.catalog.domain.Book;
import com.subrutin.lingkar.catalog.domain.Category;
import com.subrutin.lingkar.catalog.domain.Publisher;
import com.subrutin.lingkar.catalog.domain.dto.BookQueryDTO;
import com.subrutin.lingkar.catalog.domain.dto.PageQuery;
import com.subrutin.lingkar.catalog.exception.ResourceNotFoundException;
import com.subrutin.lingkar.catalog.repository.BookRepository;
import com.subrutin.lingkar.catalog.service.AuthorService;
import com.subrutin.lingkar.catalog.service.BookService;
import com.subrutin.lingkar.catalog.service.CategoryService;
import com.subrutin.lingkar.catalog.service.PublisherService;
import com.subrutin.lingkar.catalog.util.PaginationUtil;
import com.subrutin.lingkar.catalog.web.dto.AuthorListResponseDTO;
import com.subrutin.lingkar.catalog.web.dto.BookCreateRequestDTO;
import com.subrutin.lingkar.catalog.web.dto.BookDetailResponseDTO;
import com.subrutin.lingkar.catalog.web.dto.BookListResponseDTO;
import com.subrutin.lingkar.catalog.web.dto.BookUpdateRequestDTO;
import com.subrutin.lingkar.catalog.web.dto.CategoryListResponseDTO;
import com.subrutin.lingkar.catalog.web.dto.IdResponseDTO;
import com.subrutin.lingkar.catalog.web.dto.PublisherListResponseDTO;
import com.subrutin.lingkar.catalog.web.dto.ResultPageResponseDTO;

import io.quarkus.panache.common.Page;
import io.quarkus.panache.common.Sort;
import io.quarkus.runtime.util.StringUtil;
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


    @Override
    public BookDetailResponseDTO findBookDetail(Long id) {
       // 1. get book 
        Book book = bookRepository.findBookById(id)
        .orElseThrow(()-> new ResourceNotFoundException("Book not found"));
       // book-> publisher
        Publisher publisher = book.getPublisher();
       // book -> author
        Set<Author> authors = book.getAuthors();
       // book -> category
        Set<Category> categories = book.getCategories();
       //author-> dto
        Set<AuthorListResponseDTO> authorsDTO = authors.stream().map(a->{
            return new AuthorListResponseDTO(a.getId(), a.getName());
        }).collect(Collectors.toSet());
       // category -> dto
        Set<CategoryListResponseDTO> categoriesDTO =  categories.stream().map(c->{
            return new CategoryListResponseDTO(c.getCode(), c.getName());
        }).collect(Collectors.toSet());
       //publisher -> dto
        PublisherListResponseDTO publisherDTO = new PublisherListResponseDTO(
            publisher.getId(), 
            publisher.getName());
        return new BookDetailResponseDTO(
            book.getId(), 
            book.getTitle(),
            book.getDescription(),
            book.getPages(),
            book.getYear(),
            publisherDTO, 
            authorsDTO, 
            categoriesDTO);
    }


    @Transactional
    @Override
    public void updateBook(Long id, BookUpdateRequestDTO dto) {
        // 1 get book by id
        Book book =  bookRepository.findBookById(id)
            .orElseThrow(()->new ResourceNotFoundException("book not found"));
        //2 get authors by authors id
        Set<Author> authors = authorService.findAllAuthors(dto.authorIds());
        //3, get publisher by id
        Publisher publisher = publisherService.findPublisherById(dto.publisherId());
        //4/ get categories by code
        Set<Category> categories = categoryService.findCategories(dto.categoryCodes().stream()
            .map(String::toUpperCase).collect(Collectors.toList()));
        //dto -> book
        book.setAuthors(authors);
        book.setCategories(categories);
        book.setPublisher(publisher);
        book.setTitle(dto.title());
        book.setPages(dto.pages());
        book.setYear(dto.year());
        book.setDescription(dto.description());
        bookRepository.save(book);
    }


    @Override
    public void deleteBook(Long id) {
        bookRepository.findBookById(id)
        .orElseThrow(()-> new ResourceNotFoundException("Book not found"));
        bookRepository.softDeleteBookById(id);
    }


    @Override
    public ResultPageResponseDTO<BookListResponseDTO> findBookList(Integer pages, Integer limit, String sortBy,
            String direction, String bookTitle) {
        bookTitle = StringUtil.isNullOrEmpty(bookTitle)? "%" :bookTitle+"%";
        Sort sort = Sort.by(sortBy, PaginationUtil.getDirection(direction));
        Page page = Page.of(pages, limit);

		PageQuery<Book> resultPage =  bookRepository.findAllByTitleLikeIgnoreCase(bookTitle, sort, page);
		List<BookListResponseDTO> resultDTO= resultPage
        .result().stream().map((b)->{
			return new BookListResponseDTO(b.getId(), 
					b.getTitle(),
			new PublisherListResponseDTO(b.getPublisher().getId(),b.getTitle()),
			b.getAuthors().stream().map(a->
				new AuthorListResponseDTO(a.getId(), a.getName())
				).collect(Collectors.toSet()),
			b.getCategories().stream().map(c->
				new CategoryListResponseDTO(c.getCode(), c.getName())
				).collect(Collectors.toSet())
			);
		}).collect(Collectors.toList());
		return new ResultPageResponseDTO<>(resultDTO, resultPage.pages(), resultPage.elements());
    }


    @Override
    public ResultPageResponseDTO<BookListResponseDTO> findBookListUsingJpaProjection(Integer pages, Integer limit,
            String sortBy, String direction, String bookTitle) {

        bookTitle = StringUtil.isNullOrEmpty(bookTitle)? "%" :bookTitle+"%";
        Sort sort = Sort.by(sortBy, PaginationUtil.getDirection(direction));
        Page page = Page.of(pages, limit);
        
        PageQuery<BookQueryDTO> pageResult= bookRepository.findBookListUsingJpaProjection(bookTitle, 
            sort, page);
		//collect categorySet <- bookIdSet
		Set<Long> bookIdSet= pageResult.result()
            .stream().map(b->b.bookId()).collect(Collectors.toSet());

		Map<Long, Set<CategoryListResponseDTO>> categoriesMap= categoryService.findCategoriesMap(bookIdSet);
		
		//collect authorSet <- bookIdSet
		Map<Long, Set<AuthorListResponseDTO>> authorsMap = authorService.findAuthorMap(bookIdSet);
		List<BookListResponseDTO> dtos = pageResult.result().stream().map(b->{
			PublisherListResponseDTO publisherDTO = 
					new PublisherListResponseDTO(b.publisherId(), b.publisherName());
			return new BookListResponseDTO(
					b.bookId(), 
					b.bookTitle(), 
					publisherDTO, 
					authorsMap.get(b.bookId()), 
					categoriesMap.get(b.bookId()));
		}).collect(Collectors.toList());
		
		return new ResultPageResponseDTO<>(dtos, pageResult.pages(), pageResult.elements());
    }

}
