package com.newBig.system.infrastructure.persistence;

import com.newBig.system.domain.model.Product;
import com.newBig.system.domain.repository.ProductRepository;

import java.util.List;
import java.util.ArrayList;

public class ProductMemoryRepository implements ProductRepository {

    private List<Product> products = new ArrayList<>();

    @Override
    public void save(Product product) {
        products.add(product);
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public void delete(Product product) {
        products.remove(product);
    }
}
