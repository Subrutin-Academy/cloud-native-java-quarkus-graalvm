package com.subrutin.lingkar.catalog.service;

import com.subrutin.lingkar.catalog.web.dto.BookCreateRequestDTO;
import com.subrutin.lingkar.catalog.web.dto.BookDetailResponseDTO;
import com.subrutin.lingkar.catalog.web.dto.BookUpdateRequestDTO;
import com.subrutin.lingkar.catalog.web.dto.IdResponseDTO;

public interface BookService {

    IdResponseDTO createBook(BookCreateRequestDTO dto);

    BookDetailResponseDTO findBookDetail(Long id);

    void updateBook(Long id, BookUpdateRequestDTO dto);

}
