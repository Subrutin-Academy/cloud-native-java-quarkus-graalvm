package com.subrutin.lingkar.catalog.repository.impl;

import java.util.List;

import com.subrutin.lingkar.catalog.domain.Publisher;
import com.subrutin.lingkar.catalog.repository.PublisherRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

@ApplicationScoped
public class PublisherRepositoryImpl implements PublisherRepository {

    @Inject
    private EntityManager em;

    @Override
    public List<Publisher> findAllPublisher() {
        return this.em.createQuery("SELECT p FROM Publisher p", Publisher.class).getResultList();
    }

    @Override
    public void createNewPublisher(Publisher publisher) {
        this.em.persist(publisher);
    }

    @Override
    public Publisher findPublisherById(Long id) {
       return this.em.find(Publisher.class,id);
    }

    @Override
    public void updatePublisher(Publisher publisher) {
       this.em.merge(publisher);
    }

    @Override
    public void deletePublisher(Long id) {
        Publisher publisher = findPublisherById(id);
        this.em.remove(publisher);
    }

}
