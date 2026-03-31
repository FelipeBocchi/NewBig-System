package com.newBig.system.application.usecase;

import com.newBig.system.domain.model.Product;
import com.newBig.system.domain.repository.ProductRepository;

import java.math.BigDecimal;
import java.util.List;

public class RegisterProductUseCase {

    private ProductRepository repository;

    public RegisterProductUseCase(ProductRepository repository) {
        this.repository = repository;
    }

    public void execute(String productName, String description, String department, String category, int barcode, BigDecimal costPrice, BigDecimal salePrice, int minimumStock, Product.ProductType type, Product.UnitType unit) {
        Product product = new Product(productName, description, department, category, barcode, costPrice, salePrice, minimumStock, type,  unit);
        repository.save(product);
    }

    public List<Product> listar(){
        return repository.findAll();
    }

    public List<Product> findCategory(String category) {
        return repository.findByCategory(category);
    }

    public List<Product> findType(Product.ProductType type) { return repository.findByType(type); }

    public List<Product> findSalePrice(BigDecimal price) { return repository.findBySalePrice(price); }

    public List<Product> findCostPrice(BigDecimal price) { return repository.findByCostPrice(price); }

    public List<Product> findEqualPrice(BigDecimal price) { return repository.findByEqualPrice(price); }

    public List<Product> findUnit(Product.UnitType unit) { return repository.findByUnit(unit); }

}
