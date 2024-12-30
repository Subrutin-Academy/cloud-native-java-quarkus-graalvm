package com.subrutin.lingkar.catalog.repository.impl;

import java.util.List;
import java.util.Optional;

import com.subrutin.lingkar.catalog.domain.Publisher;
import com.subrutin.lingkar.catalog.domain.dto.PageQuery;
import com.subrutin.lingkar.catalog.repository.PublisherRepository;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import io.quarkus.panache.common.Page;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PublisherRepositoryImpl implements PublisherRepository, PanacheRepositoryBase<Publisher, Long> {

    @Override
    public List<Publisher> findAllPublishers() {
        return this.findAll().list();
    }

    @Override
    public Optional<Publisher> findPublisherById(Long id) {

        return Optional.of(this.findById(id));
    }

    @Override
    public void updatePublisher(Publisher publisher) {
        this.persist(publisher);
    }

    @Override
    public void createPublisher(Publisher publisher) {
       this.persist(publisher);
    }

    @Override
    public void deletePublisher(Long id) {
      this.deleteById(id);
    }

    @Override
    public PageQuery<Publisher> findPublisherList(String publisherName, Sort sort, Page page) {
        PanacheQuery<Publisher> query = this.find("WHERE UPPER(name) LIKE ?1", sort, publisherName.toUpperCase());
        List<Publisher> queryList = query.page(page).list();
        return new PageQuery<>(queryList, query.pageCount(), query.count());
    }

}
