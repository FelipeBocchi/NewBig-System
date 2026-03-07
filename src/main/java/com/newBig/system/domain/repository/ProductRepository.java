package com.newBig.system.domain.repository;

import com.newBig.system.domain.model.Product;

import java.util.List;

public interface ProductRepository {

    void save(Product product);

    List<Product> findAll();

    void delete(Product product);
}
