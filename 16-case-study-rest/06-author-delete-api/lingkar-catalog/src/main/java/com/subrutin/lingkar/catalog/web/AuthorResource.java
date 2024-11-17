package com.subrutin.lingkar.catalog.web;

import java.net.URI;
import java.util.List;

import org.jboss.resteasy.reactive.RestResponse;

import com.subrutin.lingkar.catalog.service.AuthorService;
import com.subrutin.lingkar.catalog.web.dto.AuthorRequestDTO;
import com.subrutin.lingkar.catalog.web.dto.AuthorDetailResponseDTO;
import com.subrutin.lingkar.catalog.web.dto.AuthorListResponseDTO;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;

@Path("/v1/authors")
public class AuthorResource {

    private final AuthorService authorService;

    public AuthorResource(AuthorService authorService) {
        this.authorService = authorService;
    }


    @POST
    public RestResponse<Void> createAuthor(AuthorRequestDTO dto){
        authorService.createAuthor(dto);
        return RestResponse.created(URI.create("/v1/authors"));
    }

    @GET
    @Path("/{authorId}")
    public RestResponse<AuthorDetailResponseDTO> findAuthorDetail(@PathParam("authorId") Long authorId){
        AuthorDetailResponseDTO dto = authorService.findAuthorDetail(authorId);
        return RestResponse.ok(dto);
    }
    
    @GET
    public RestResponse<List<AuthorListResponseDTO>> findAuthorList(@QueryParam("authorName") String authorName){
        List<AuthorListResponseDTO> dtos = authorService.findAuthorList(authorName);
        return RestResponse.ok(dtos);

    }

    @PUT
    @Path("/{authorId}")
    public RestResponse<Void> updateAuthor(@PathParam("authorId") Long authorId, AuthorRequestDTO dto){
        authorService.updateAuthor(authorId, dto);
        return RestResponse.ok();
    }

    @DELETE
    @Path("{authorId}")
    public RestResponse<Void> deleteAuthor(@PathParam("authorId") Long id){
        authorService.delete(id);
        return RestResponse.noContent();
    }

    
}
