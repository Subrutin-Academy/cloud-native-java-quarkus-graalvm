package com.subrutin.lingkar.catalog.web;

import org.jboss.resteasy.reactive.RestResponse;

import com.subrutin.lingkar.catalog.service.BookService;
import com.subrutin.lingkar.catalog.web.dto.BookCreateRequestDTO;
import com.subrutin.lingkar.catalog.web.dto.BookDetailResponseDTO;
import com.subrutin.lingkar.catalog.web.dto.BookListResponseDTO;
import com.subrutin.lingkar.catalog.web.dto.BookUpdateRequestDTO;
import com.subrutin.lingkar.catalog.web.dto.CategoryListResponseDTO;
import com.subrutin.lingkar.catalog.web.dto.IdResponseDTO;
import com.subrutin.lingkar.catalog.web.dto.ResultPageResponseDTO;

import jakarta.validation.Valid;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;

@Path("/v1/books")
public class BookResource {

    private final BookService bookService;

    public BookResource(BookService bookService) {
        this.bookService = bookService;
    }

    @POST
    public RestResponse<IdResponseDTO> createBook(@Valid BookCreateRequestDTO dto) {
        return RestResponse.ok(bookService.createBook(dto));
    }

    @GET
    @Path("{id}")
    public RestResponse<BookDetailResponseDTO> findBookById(@PathParam("id") Long id) {
        return RestResponse.ok(bookService.findBookDetail(id));
    }

    @PUT
    @Path("{id}")
    public RestResponse<Void> updateBook(@PathParam("id") Long id,
            @Valid BookUpdateRequestDTO dto) {
        bookService.updateBook(id, dto);
        return RestResponse.ok();
    }

    @DELETE
    @Path("{id}")
    public RestResponse<Void> deleteBook(@PathParam("id") Long id){
        bookService.deleteBook(id);
        return RestResponse.noContent();
    }

    @GET
    public RestResponse<ResultPageResponseDTO<BookListResponseDTO>> findBookList(
            @QueryParam("pages") @DefaultValue("0") Integer pages,
            @QueryParam("limit") @DefaultValue("10") Integer limit,
            @QueryParam("sortBy") @DefaultValue("title") String sortBy,
            @QueryParam("direction") @DefaultValue("asc") String direction,
            @QueryParam("bookTitle") String bookTitle) {
        return RestResponse.ok(bookService.findBookListUsingJpaProjection(pages, limit, sortBy, direction, bookTitle));

    }
}
