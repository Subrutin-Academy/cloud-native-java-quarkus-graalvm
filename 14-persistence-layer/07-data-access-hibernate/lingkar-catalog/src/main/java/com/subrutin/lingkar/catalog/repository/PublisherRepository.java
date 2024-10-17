package com.subrutin.lingkar.catalog.repository;

import java.util.List;

import com.subrutin.lingkar.catalog.domain.Publisher;

public interface PublisherRepository {

    public List<Publisher> findAllPublisher();

    //create
    public void createNewPublisher(Publisher publisher);

    //read
    public Publisher findPublisherById(Long id);

    //update
    public void updatePublisher(Publisher publisher);

    //delete
    public void deletePublisher(Long id);

}
