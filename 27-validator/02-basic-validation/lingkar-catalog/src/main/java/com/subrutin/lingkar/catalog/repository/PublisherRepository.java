package com.subrutin.lingkar.catalog.repository;

import java.util.List;
import java.util.Optional;

import com.subrutin.lingkar.catalog.domain.Publisher;
import com.subrutin.lingkar.catalog.domain.dto.PageQuery;

import io.quarkus.panache.common.Page;
import io.quarkus.panache.common.Sort;

public interface PublisherRepository {

    public List<Publisher> findAllPublishers();

    public Optional<Publisher> findPublisherById(Long id);

    public void updatePublisher(Publisher publisher);

    public void createPublisher(Publisher publisher);

    public void deletePublisher(Long id);

    public PageQuery<Publisher> findPublisherList(String publisherName, Sort sort, Page page);

}
