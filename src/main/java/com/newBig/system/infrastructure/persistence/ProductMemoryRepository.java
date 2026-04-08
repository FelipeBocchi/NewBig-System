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
    public List<Product> searchByBarcode(int barcode) {
        return List.of();
    }

    @Override
    public Product searchById(UUID id) {

        return products.stream().
                filter( p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    // == Filtos ==

    @Override
    public List<Product> findByCategory(String category) {

        return products.stream()
                .filter(p -> p.getCategory().equalsIgnoreCase(category))
                .toList();
    }

    @Override
    public List<Product> findByType(Product.ProductType type) {

        return products.stream()
                .filter(p -> p.getType().equals(type))
                .toList();
    }

    // diferença de equals e equalsIgnoreCase?


    @Override
    public List<Product> findBySalePrice(BigDecimal price) {

        return products.stream()
                .filter(p -> p.getSalePrice() != null && p.getSalePrice().compareTo(price) <= 0)
                .toList();
    }

    @Override
    public List<Product> findByCostPrice(BigDecimal price) {

        return products.stream()
                .filter(p -> p.getCostPrice() != null && p.getSalePrice().compareTo(price) <= 0)
                .toList();
    }

    @Override
    public List<Product> findByEqualPrice(BigDecimal price) {

        return products.stream()
                .filter(p -> p.getSalePrice() != null && p.getSalePrice().compareTo(price) == 0)
                .toList();
    }

    @Override
    public List<Product> findByUnit(Product.UnitType unit) {

        return products.stream()
                .filter(p -> p.getType().equals(unit))
                .toList();
    }
}
