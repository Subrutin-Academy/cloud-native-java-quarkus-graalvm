package com.subrutin.quarkus.learnjpa.repository.impl;

import java.util.Optional;

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

}
