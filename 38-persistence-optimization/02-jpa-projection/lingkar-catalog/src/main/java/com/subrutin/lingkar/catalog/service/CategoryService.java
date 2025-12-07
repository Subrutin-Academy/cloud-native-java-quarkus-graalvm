package com.subrutin.lingkar.catalog.service;

import java.util.List;
import java.util.Set;

import com.subrutin.lingkar.catalog.domain.Category;
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

    public Set<Category> findCategories(List<String> categoryCodes);

    public void updateCategory(String code, CategoryUpdateRequestDTO dto);

    public void deleteCategory(String code);

}
