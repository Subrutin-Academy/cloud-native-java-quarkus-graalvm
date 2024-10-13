package com.subrutin.lingkar.catalog.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;

import com.subrutin.lingkar.catalog.domain.Publisher;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;

@QuarkusTest
@TestTransaction
public class PublisherRepositoryTest {

    @Inject
    private PublisherRepository publisherRepository;

    @Test
    void testFindAll() {
        List<Publisher> publishers = publisherRepository.findAll();
        assertEquals(5, publishers.size());

    }

    @Test
    void testFindById() {
        Optional<Publisher> publisher = publisherRepository.findById(1L);
        assertEquals(true, publisher.isPresent());
        assertEquals("Bentang Pustaka", publisher.get().getName());
    }


    @Test
    void testCreatePublisher(){
        Publisher publisher = new Publisher();
        publisher.setName("Penguin Random House");
        publisher.setDescription("Penguin Random House, hasil merger antara Penguin Books dan Random House pada 2013, adalah penerbit buku terbesar di dunia");
        publisherRepository.save(publisher);
        assertEquals(6, publisherRepository.count());
    }

    @Test
    void testUpdatePublisher(){
        
        Publisher publisher = publisherRepository.findById(1L).get();
        publisher.setName("Penerbit Bentang Pustaka");
        publisherRepository.save(publisher);
        Publisher publisher2 = publisherRepository.findById(1L).get();
        assertEquals("Penerbit Bentang Pustaka", publisher2.getName());
    }

    @Test
    void testDeletePublisher(){
        publisherRepository.deleteById(1L);
        assertEquals(false, publisherRepository.findById(1L).isPresent());
    }

    @Test
    void testFindAllByName() {
        List<Publisher> publishers= publisherRepository.findAllByNameLikeIgnoreCase("er%".toUpperCase());
        assertEquals(1, publishers.size());
    }
}
