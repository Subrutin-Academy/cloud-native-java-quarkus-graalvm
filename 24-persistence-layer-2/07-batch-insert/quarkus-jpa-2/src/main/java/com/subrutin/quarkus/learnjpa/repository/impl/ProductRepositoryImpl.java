package com.subrutin.quarkus.learnjpa.repository.impl;

import java.util.List;

import com.subrutin.quarkus.learnjpa.domain.Product;
import com.subrutin.quarkus.learnjpa.repository.ProductRepository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class ProductRepositoryImpl implements ProductRepository, PanacheRepositoryBase<Product, Long> {

    @Transactional
    @Override
    public void save(Product product) {
        this.persist(product);
    }

    @Transactional
    @Override
    public void saveAll(List<Product> products) {
       this.persist(products);
    }

}
