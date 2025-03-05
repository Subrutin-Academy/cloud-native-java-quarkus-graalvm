package com.subrutin.lingkar.catalog.repository.impl;

import java.util.List;

import com.subrutin.lingkar.catalog.domain.Category;
import com.subrutin.lingkar.catalog.domain.dto.PageQuery;
import com.subrutin.lingkar.catalog.repository.CategoryRepository;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import io.quarkus.panache.common.Page;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class CategoryRepositoryImpl implements CategoryRepository, 
                                        PanacheRepositoryBase<Category, String> {

    @Transactional
    @Override
    public void save(Category category) {
       this.persist(category);
    }

   @Override
   public PageQuery<Category> findCategoryList(String categoryName, Sort sort, Page page) {
      PanacheQuery<Category> query = this.find("WHERE UPPER(name) LIKE ?1",sort, 
         categoryName.toUpperCase());
      List<Category> queryList = query.page(page).list();
      return new PageQuery<>(queryList, query.pageCount(), query.count());
   }

}
