package com.subrutin.lingkar.catalog.web;

import java.net.URI;

import org.jboss.resteasy.reactive.RestResponse;

import com.subrutin.lingkar.catalog.service.CategoryService;
import com.subrutin.lingkar.catalog.web.dto.CategoryCreateRequestDTO;
import com.subrutin.lingkar.catalog.web.dto.CategoryDetailResponseDTO;
import com.subrutin.lingkar.catalog.web.dto.CategoryListResponseDTO;
import com.subrutin.lingkar.catalog.web.dto.CategoryUpdateRequestDTO;
import com.subrutin.lingkar.catalog.web.dto.PublisherListResponseDTO;
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

    @GET
    @Path("{categoryCode}")
    public RestResponse<CategoryDetailResponseDTO> findCategoryDetail(@PathParam("categoryCode") String categoryCode){
        return RestResponse.ok(categoryService.findCategoryDetail(categoryCode));
    }

    @PUT
    @Path("{categoryCode}")
    public RestResponse<Void> updateCategory(@PathParam("categoryCode") String categoryCode, CategoryUpdateRequestDTO dto){
        categoryService.updateCategory(categoryCode, dto);
        return RestResponse.ok();
    }

    @DELETE
    @Path("{categoryCode}")
    public RestResponse<Void> deleteCategory(@PathParam("categoryCode") String categoryCode){
        categoryService.deleteCategory(categoryCode);
        return RestResponse.noContent();
    }
}
