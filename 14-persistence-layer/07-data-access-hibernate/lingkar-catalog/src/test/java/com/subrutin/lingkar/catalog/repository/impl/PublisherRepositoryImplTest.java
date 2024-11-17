package com.subrutin.lingkar.catalog.repository.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.subrutin.lingkar.catalog.domain.Publisher;
import com.subrutin.lingkar.catalog.repository.PublisherRepository;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;

@QuarkusTest
@TestTransaction
public class PublisherRepositoryImplTest {

    @Inject
    private PublisherRepository publisherRepository;

    @Test
    void testFindAllPublisher() {
        List<Publisher> publishers = this.publisherRepository.findAllPublisher();
        assertEquals(5, publishers.size());

    }

    @Test
    void testCreateNewPublisher() {
        Publisher publisher = new Publisher();
        publisher.setName("Penguin Random House");
        publisher.setDescription("Penguin Random House, hasil merger antara Penguin Books dan Random House pada 2013, adalah penerbit buku terbesar di dunia");
        publisherRepository.createNewPublisher(publisher);

        assertEquals(6, publisherRepository.findAllPublisher().size());
    }

    @Test
    void testDeletePublisher() {
        publisherRepository.deletePublisher(1L);
        Publisher publisher = this.publisherRepository.findPublisherById(1L);
        assertEquals(null, publisher);

    }

    @Test
    void testFindPublisherById() {
        Publisher publisher = this.publisherRepository.findPublisherById(1L);
        assertEquals("Bentang Pustaka", publisher.getName());
        
    }

    @Test
    void testUpdatePublisher() {
        Publisher publisher = publisherRepository.findPublisherById(1L);
        publisher.setName("Penerbit Bentang Pustaka");
        publisherRepository.updatePublisher(publisher);
        Publisher publisher2 = publisherRepository.findPublisherById(1L);
        assertEquals("Penerbit Bentang Pustaka", publisher2.getName());

    }
}
