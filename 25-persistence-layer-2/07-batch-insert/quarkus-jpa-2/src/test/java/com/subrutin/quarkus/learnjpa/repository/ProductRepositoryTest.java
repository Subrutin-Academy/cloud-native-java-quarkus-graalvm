package com.subrutin.quarkus.learnjpa.repository;

import java.math.BigDecimal;
import java.util.List;

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

        Product product3 = new Product();
        product3.setName("Asus Tuf A15");
        product3.setRetailPrice(BigDecimal.valueOf(12_000_000));

        productRepository.save(product3);
    }

    @Test
    void testSaveAll() {
        
        Product product1 = new Product();
        product1.setName("Lenovo Thinkpad E14");
        product1.setRetailPrice(BigDecimal.valueOf(20_000_000));

        Product product2 = new Product();
        product2.setName("Macbook Pro M4");
        product2.setRetailPrice(BigDecimal.valueOf(20_000_000));

        Product product3 = new Product();
        product3.setName("Lenovo Yoga Slim 7i Pro");
        product3.setRetailPrice(BigDecimal.valueOf(20_000_000));

        productRepository.saveAll(List.of(product1, product2, product3));

        
    }
}
