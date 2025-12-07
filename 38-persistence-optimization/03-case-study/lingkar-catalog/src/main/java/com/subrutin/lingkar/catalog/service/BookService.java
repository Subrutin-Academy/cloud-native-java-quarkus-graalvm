package com.subrutin.lingkar.catalog.service;

import com.subrutin.lingkar.catalog.web.dto.BookCreateRequestDTO;
import com.subrutin.lingkar.catalog.web.dto.BookDetailResponseDTO;
import com.subrutin.lingkar.catalog.web.dto.BookListResponseDTO;
import com.subrutin.lingkar.catalog.web.dto.BookUpdateRequestDTO;
import com.subrutin.lingkar.catalog.web.dto.IdResponseDTO;
import com.subrutin.lingkar.catalog.web.dto.ResultPageResponseDTO;

public interface BookService {

    IdResponseDTO createBook(BookCreateRequestDTO dto);

    BookDetailResponseDTO findBookDetail(Long id);

    void updateBook(Long id, BookUpdateRequestDTO dto);

    void deleteBook(Long id);

    public ResultPageResponseDTO<BookListResponseDTO> findBookList(Integer pages, 
		Integer limit, 
		String sortBy,
		String direction, 
		String bookTitle);

    public ResultPageResponseDTO<BookListResponseDTO> findBookListUsingJpaProjection(Integer pages, 
		Integer limit, 
		String sortBy,
		String direction, 
		String bookTitle);


}
