package com.subrutin.lingkar.catalog.repository.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.subrutin.lingkar.catalog.domain.AppUser;
import com.subrutin.lingkar.catalog.domain.dto.PageQuery;
import com.subrutin.lingkar.catalog.repository.AppUserRepository;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import io.quarkus.panache.common.Page;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class AppUserRepositoryImpl implements AppUserRepository, PanacheRepositoryBase<AppUser, Long> {

    @Transactional
    @Override
    public void save(AppUser appUser) {
        this.persist(appUser);
    }

    @Override
    public PageQuery<AppUser> findAppUserList(String name, Sort sort, Page page) {
        PanacheQuery<AppUser> query = this.find("WHERE UPPER(name) LIKE ?1", sort, name.toUpperCase());
        List<AppUser> queryList = query.page(page).list();
        return new PageQuery<>(queryList, query.pageCount(), query.count());
    }

    @Override
    public Optional<AppUser> findAppUserDetail(UUID id) {
       return this.find("secureId", id).firstResultOptional();
    }

}
