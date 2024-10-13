package com.subrutin.lingkar.catalog.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
@TestTransaction
public class PublisherTest {

    
    @Test
    void testCreatePublisher() {
        Publisher publisher = new Publisher();
        publisher.name = "Penguin Random House";
        publisher.description = "Penguin Random House, hasil merger antara Penguin Books dan Random House pada 2013, adalah penerbit buku terbesar di dunia";

        Publisher.createPublisher(publisher);
        assertEquals(6, Publisher.findAllPublishers().size());

    }

    @Test
    void testDeletePublisher() {

        Publisher.deletePublisher(1L);
        Publisher publisher = Publisher.findPublisherById(1L);
        assertEquals(null, publisher);
    }

    @Test
    void testFindAllPublishers() {
        List<Publisher> publishers = Publisher.findAllPublishers();
        assertEquals(5, publishers.size());
    }

    @Test
    void testFindPublisherById() {
        Publisher publisher = Publisher.findPublisherById(1L);
        assertEquals("Bentang Pustaka", publisher.name);

    }

    @Test
    void testUpdatePublisher() {
        Publisher publisher = Publisher.findPublisherById(1L);
        publisher.name = "Penerbit Bentang Pustaka";
        Publisher.updatePublisher(publisher);
        Publisher publisher2 = Publisher.findPublisherById(1L);
        assertEquals("Penerbit Bentang Pustaka", publisher2.name);



    }
}
