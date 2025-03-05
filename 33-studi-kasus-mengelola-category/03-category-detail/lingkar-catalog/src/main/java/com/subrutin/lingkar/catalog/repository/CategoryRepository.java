package com.subrutin.lingkar.catalog.repository;

import java.util.Optional;

import com.subrutin.lingkar.catalog.domain.Category;
import com.subrutin.lingkar.catalog.domain.dto.PageQuery;

import io.quarkus.panache.common.Page;
import io.quarkus.panache.common.Sort;

public interface CategoryRepository {

    public void save(Category category);

    public PageQuery<Category> findCategoryList(String categoryName, Sort sort, Page page);

    public Optional<Category> findCategoryDetail(String categoryCode);

}
