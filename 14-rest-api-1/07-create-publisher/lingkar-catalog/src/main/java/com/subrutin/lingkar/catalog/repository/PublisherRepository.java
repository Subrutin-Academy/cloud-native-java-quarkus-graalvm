package com.subrutin.lingkar.catalog.repository;

import java.util.List;

import com.subrutin.lingkar.catalog.domain.Publisher;

public interface PublisherRepository {

    public List<Publisher> findAllPublishers();

    public Publisher findPublisherById(Long id);

    public void updatePublisher(Publisher publisher);

    public void createPublisher(Publisher publisher);

    public void deletePublisher(Long id);

}
