package com.subrutin.lingkar.catalog.repository;

import com.subrutin.lingkar.catalog.domain.AppUser;
import com.subrutin.lingkar.catalog.domain.dto.PageQuery;

import io.quarkus.panache.common.Page;
import io.quarkus.panache.common.Sort;

public interface AppUserRepository {

    public void save(AppUser appUser);

    public PageQuery<AppUser> findAppUserList(String name,  Sort sort, Page page);

}
