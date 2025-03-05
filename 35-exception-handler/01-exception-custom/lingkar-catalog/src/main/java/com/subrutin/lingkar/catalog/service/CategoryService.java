package com.subrutin.lingkar.catalog.service;

import com.subrutin.lingkar.catalog.web.dto.CategoryCreateRequestDTO;
import com.subrutin.lingkar.catalog.web.dto.CategoryDetailResponseDTO;
import com.subrutin.lingkar.catalog.web.dto.CategoryListResponseDTO;
import com.subrutin.lingkar.catalog.web.dto.CategoryUpdateRequestDTO;
import com.subrutin.lingkar.catalog.web.dto.ResultPageResponseDTO;

public interface CategoryService {

    public void createCategory(CategoryCreateRequestDTO dto);

    public ResultPageResponseDTO<CategoryListResponseDTO> findCategoryList(
        Integer pages,
        Integer limit,
        String sortBy,
        String direction,
        String categoryName
    );

    public CategoryDetailResponseDTO findCategoryDetail(String code);

    public void updateCategory(String code, CategoryUpdateRequestDTO dto);

    public void deleteCategory(String code);

}
