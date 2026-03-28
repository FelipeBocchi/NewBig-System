package com.newBig.system.domain.service;

import com.newBig.system.domain.model.Product;
import com.newBig.system.domain.repository.ProductRepository;

import java.math.BigDecimal;
import java.util.List;

public class ProductService {

    private ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public void register(Product product){
        repository.save(product);
    }

    public List<Product> list(){
        return repository.findAll();
    }

    public List<Product> getProductsByCategory(String category){
        return repository.findByCategory(category);
    }

    public List<Product> getProductByType(Product.ProductType type) {
        return repository.findByType(type);
    }

    public List<Product> getProductLowStock() {
        return repository.findLowStock();
    }

    public List<Product> getProductBySalePrice(BigDecimal price) { return repository.findBySalePrice(price); }

    public List<Product> getProductByCostPrice(BigDecimal price) { return repository.findByCostPrice(price); }

    public List<Product> getProductByEqualPrice(BigDecimal price) { return repository.findByEqualPrice(price); }

    public List<Product> getProductByUnit(Product.UnitType unit) { return repository.findByUnit(unit); }


}
