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

    public void execute(String productName, String description, String department, String category, String sku, int barcode, BigDecimal costPrice, BigDecimal salePrice, int stock, int minimumStock, Product.ProductType type, Product.UnitType unit) {
        Product product = new Product(productName, description, department, category, sku, barcode, costPrice, salePrice, stock, minimumStock, type,  unit);
        service.register(product);
    }

    public List<Product> listar(){
        return service.list();
    }

    public List<Product> findCategory(String category) {
        return service.getProductsByCategory(category);
    }

}
