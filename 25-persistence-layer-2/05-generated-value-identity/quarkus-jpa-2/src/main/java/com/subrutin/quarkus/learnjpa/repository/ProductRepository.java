package com.subrutin.quarkus.learnjpa.repository;


import com.subrutin.quarkus.learnjpa.domain.Product;

public interface ProductRepository {

    public void save(Product product);

}
