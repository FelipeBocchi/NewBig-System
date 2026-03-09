package com.newBig.system.infrastructure.persistence;

import com.newBig.system.domain.model.Product;
import com.newBig.system.domain.repository.ProductRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.ArrayList;
import java.util.UUID;

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

    @Override
    public List<Product> searchByName(String name) {
        return List.of();
    }

    @Override
    public List<Product> searchBySku(String sku) {
        return List.of();
    }

    @Override
    public List<Product> searchByBarcode(int barcode) {
        return List.of();
    }

    @Override
    public List<Product> searchById(UUID id) {
        return List.of();
    }

    @Override
    public List<Product> findByCategory(String category) {

        return products.stream()
                .filter(p -> p.getCategory().equalsIgnoreCase(category))
                .toList();
    }

    @Override
    public List<Product> findByType(Product.ProductType type) {
        return List.of();
    }

    @Override
    public List<Product> findLowStock() {
        return List.of();
    }

    @Override
    public List<Product> findByPrice(BigDecimal price) {
        return List.of();
    }

    @Override
    public List<Product> findByUnit(Product.UnitType type) {
        return List.of();
    }
}
