package com.subrutin.lingkar.catalog.web;

import org.jboss.resteasy.reactive.RestResponse;

import com.subrutin.lingkar.catalog.service.BookService;
import com.subrutin.lingkar.catalog.web.dto.BookCreateRequestDTO;
import com.subrutin.lingkar.catalog.web.dto.IdResponseDTO;

import jakarta.validation.Valid;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("/v1/books")
public class BookResource {

    private final BookService bookService;

    public BookResource(BookService bookService) {
        this.bookService = bookService;
    }

    @POST
    public RestResponse<IdResponseDTO> createBook(@Valid BookCreateRequestDTO dto){
        return RestResponse.ok(bookService.createBook(dto));
    }
}
