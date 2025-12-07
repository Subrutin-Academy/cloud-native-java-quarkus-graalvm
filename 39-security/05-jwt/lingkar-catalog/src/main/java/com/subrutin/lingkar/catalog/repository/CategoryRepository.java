package com.subrutin.lingkar.catalog.repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.subrutin.lingkar.catalog.domain.Category;
import com.subrutin.lingkar.catalog.domain.dto.CategoryQueryDTO;
import com.subrutin.lingkar.catalog.domain.dto.PageQuery;

import io.quarkus.panache.common.Page;
import io.quarkus.panache.common.Sort;

public interface CategoryRepository {

    public void save(Category category);

    public PageQuery<Category> findCategoryList(String categoryName, Sort sort, Page page);

    public Optional<Category> findCategoryDetail(String categoryCode);

    public List<Category> findCategoriesByCodeIn(List<String> codes);

    public void deleteCategory(String code);

    public Set<CategoryQueryDTO> findCategoryByBookIdSet(Set<Long> bookIdSet);

}
