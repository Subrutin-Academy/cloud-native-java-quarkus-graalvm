package com.subrutin.lingkar.catalog.service;

import com.subrutin.lingkar.catalog.web.dto.BookCreateRequestDTO;
import com.subrutin.lingkar.catalog.web.dto.IdResponseDTO;

public interface BookService {

    IdResponseDTO createBook(BookCreateRequestDTO dto);

}
