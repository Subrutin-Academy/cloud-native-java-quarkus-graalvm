package com.subrutin.lingkar.catalog.service.impl;

import com.subrutin.lingkar.catalog.domain.Publisher;
import com.subrutin.lingkar.catalog.repository.PublisherRepository;
import com.subrutin.lingkar.catalog.service.PublisherService;
import com.subrutin.lingkar.catalog.web.dto.PublisherCreateRequestDTO;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class PublisherServiceImpl implements PublisherService{

    private final PublisherRepository publisherRepository;

    @Inject
    public PublisherServiceImpl(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }


    @Transactional
    @Override
    public void createPublisher(PublisherCreateRequestDTO dto) {
        Publisher publisher = new Publisher();
        publisher.setName(dto.name());
        publisher.setDescription(dto.description());
        publisherRepository.createPublisher(publisher);
       
    }

}
