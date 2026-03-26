package com.newBig.system.application.usecase;

import com.newBig.system.domain.model.Product;
import com.newBig.system.domain.service.ProductService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class RegisterProductUseCase {

    private ProductService service;

    public RegisterProductUseCase(ProductService service) {
        this.service = service;
    }

    public void execute(String productName, String description, String department, String category, int barcode, BigDecimal costPrice, BigDecimal salePrice, int minimumStock, Product.ProductType type, Product.UnitType unit) {
        Product product = new Product(productName, description, department, category, barcode, costPrice, salePrice, minimumStock, type,  unit);
        service.register(product);
    }

    public List<Product> listar(){
        return service.list();
    }

    public List<Product> findCategory(String category) {
        return service.getProductsByCategory(category);
    }

    public List<Product> findType(Product.ProductType type) { return service.getProductByType(type); }

    public List<Product> findSalePrice(BigDecimal price) { return  service.getProductBySalePrice(price); }

    public List<Product> findCostPrice(BigDecimal price) { return  service.getProductByCostPrice(price); }

    public List<Product> findEqualPrice(BigDecimal price) { return  service.getProductByEqualPrice(price); }

    public List<Product> findUnit(Product.UnitType unit) { return  service.getProductByUnit(unit); }

}
