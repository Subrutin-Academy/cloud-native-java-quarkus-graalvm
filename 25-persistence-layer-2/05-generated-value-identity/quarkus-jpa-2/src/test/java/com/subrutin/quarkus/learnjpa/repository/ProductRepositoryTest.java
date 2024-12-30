package com.subrutin.quarkus.learnjpa.repository;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import com.subrutin.quarkus.learnjpa.domain.Product;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;

@QuarkusTest
public class ProductRepositoryTest {
    
    @Inject
    ProductRepository productRepository;

    @Test
    void testSave() {
        Product product1 = new Product();
        product1.setName("Lenovo Legion SLIM5");
        product1.setRetailPrice(BigDecimal.valueOf(20_000_000));

        productRepository.save(product1);

        Product product2 = new Product();
        product2.setName("Macbook Air M1");
        product2.setRetailPrice(BigDecimal.valueOf(20_000_000));

        productRepository.save(product2);
    }
}
