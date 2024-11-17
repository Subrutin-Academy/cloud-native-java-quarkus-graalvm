package com.subrutin.lingkar.catalog.web;

import java.net.URI;

import org.jboss.resteasy.reactive.RestResponse;

import com.subrutin.lingkar.catalog.service.AuthorService;
import com.subrutin.lingkar.catalog.web.dto.AuthorCreateRequestDTO;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("/v1/authors")
public class AuthorResource {

    private final AuthorService authorService;

    public AuthorResource(AuthorService authorService) {
        this.authorService = authorService;
    }


    @POST
    public RestResponse<Void> createAuthor(AuthorCreateRequestDTO dto){
        authorService.createAuthor(dto);
        return RestResponse.created(URI.create("/v1/authors"));
    }
    
}
