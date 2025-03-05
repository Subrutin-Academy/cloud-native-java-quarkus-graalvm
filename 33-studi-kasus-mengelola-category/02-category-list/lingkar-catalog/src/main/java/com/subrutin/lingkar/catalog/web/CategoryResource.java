package com.subrutin.lingkar.catalog.web;

import java.net.URI;

import org.jboss.resteasy.reactive.RestResponse;

import com.subrutin.lingkar.catalog.service.CategoryService;
import com.subrutin.lingkar.catalog.web.dto.CategoryCreateRequestDTO;
import com.subrutin.lingkar.catalog.web.dto.CategoryListResponseDTO;
import com.subrutin.lingkar.catalog.web.dto.PublisherListResponseDTO;
import com.subrutin.lingkar.catalog.web.dto.ResultPageResponseDTO;

import jakarta.validation.Valid;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;

@Path("/v1/categories")
public class CategoryResource {

    private final CategoryService categoryService;

    

    public CategoryResource(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @POST
    public RestResponse<Void> createCategory(@Valid CategoryCreateRequestDTO dto){
        categoryService.createCategory(dto);
        return RestResponse.created(URI.create("/v1/categories"));
    }

    @GET
    public RestResponse<ResultPageResponseDTO<CategoryListResponseDTO>> findCategoryList(
        @QueryParam("pages") @DefaultValue("0") Integer pages,
        @QueryParam("limit") @DefaultValue("10") Integer limit,
        @QueryParam("sortBy") @DefaultValue("name") String sortBy,
        @QueryParam("direction") @DefaultValue("asc") String direction,
        @QueryParam("categoryName") String categoryName
    ){
        return RestResponse.ok(categoryService.findCategoryList(pages, limit, sortBy, direction, categoryName));

    }
}
