package com.subrutin.lingkar.catalog.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.subrutin.lingkar.catalog.domain.Category;
import com.subrutin.lingkar.catalog.domain.dto.PageQuery;
import com.subrutin.lingkar.catalog.exception.ResourceNotFoundException;
import com.subrutin.lingkar.catalog.repository.CategoryRepository;
import com.subrutin.lingkar.catalog.service.CategoryService;
import com.subrutin.lingkar.catalog.util.PaginationUtil;
import com.subrutin.lingkar.catalog.web.dto.CategoryCreateRequestDTO;
import com.subrutin.lingkar.catalog.web.dto.CategoryDetailResponseDTO;
import com.subrutin.lingkar.catalog.web.dto.CategoryListResponseDTO;
import com.subrutin.lingkar.catalog.web.dto.CategoryUpdateRequestDTO;
import com.subrutin.lingkar.catalog.web.dto.PublisherListResponseDTO;
import com.subrutin.lingkar.catalog.web.dto.ResultPageResponseDTO;

import io.quarkus.panache.common.Page;
import io.quarkus.panache.common.Sort;
import io.quarkus.runtime.util.StringUtil;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void createCategory(CategoryCreateRequestDTO dto) {
        Category category = new Category();
        category.setCode(dto.code().toUpperCase());
        category.setName(dto.name());
        category.setDescription(dto.description());
        categoryRepository.save(category);
    }

    @Override
    public ResultPageResponseDTO<CategoryListResponseDTO> findCategoryList(Integer pages, Integer limit, String sortBy,
            String direction, String categoryName) {
        categoryName = StringUtil.isNullOrEmpty(categoryName) ? "%" : categoryName + "%";
        Sort sort = Sort.by(sortBy, PaginationUtil.getDirection(direction));
        Page page = Page.of(pages, limit);
        // repository layer
        PageQuery<Category> pageResult = categoryRepository.findCategoryList(categoryName, sort, page);
        List<CategoryListResponseDTO> dtoList = pageResult.result().stream().map(p -> {
            return new CategoryListResponseDTO(p.getCode(), p.getName());
        }).collect(Collectors.toList());
        return new ResultPageResponseDTO<>(dtoList, pageResult.pages(), pageResult.elements());
    }

    @Override
    public CategoryDetailResponseDTO findCategoryDetail(String code) {
        Category category = categoryRepository.findCategoryDetail(code)
                .orElseThrow(() -> new ResourceNotFoundException("category code is not found"));
        return new CategoryDetailResponseDTO(category.getCode(), 
            category.getName(), category.getDescription());
    }

    @Transactional
    @Override
    public void updateCategory(String code, CategoryUpdateRequestDTO dto) {
        Category category = categoryRepository.findCategoryDetail(code)
        .orElseThrow(() -> new ResourceNotFoundException("category code is not found"));
        
        category.setName(dto.name());
        category.setDescription(dto.description());
        categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(String code) {
        categoryRepository.deleteCategory(code);
    }

    @Override
    public Set<Category> findCategories(List<String> categoryCodes) {
        List<Category> categories =  categoryRepository.findCategoriesByCodeIn(categoryCodes.stream()
        .map(String::toUpperCase).collect(Collectors.toList()));
        if(categories.isEmpty() || categories.size() != categoryCodes.size()){
            throw new ResourceNotFoundException("category.code not found");
        }

        return new HashSet<>(categories);
    }

}
