package com.subrutin.quarkus.learnjpa.repository;


import java.util.List;

import com.subrutin.quarkus.learnjpa.domain.Product;

public interface ProductRepository {

    public void save(Product product);

    public void saveAll(List<Product> products);

}
