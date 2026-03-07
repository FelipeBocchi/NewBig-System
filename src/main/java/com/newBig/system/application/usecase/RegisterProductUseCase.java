package com.newBig.system.application.usecase;

import com.newBig.system.domain.model.Product;
import com.newBig.system.domain.service.ProductService;

import java.util.List;

public class RegisterProductUseCase {

    private ProductService service;

    public RegisterProductUseCase(ProductService service) {
        this.service = service;
    }

    public void execute(String department, String category, String productName, String sku, int barcode, double price, int stock) {
        Product product = new Product(department, category, productName, sku, barcode, price, stock);
        service.register(product);
    }

    public List<Product> listar(){
        return service.list();
    }
}
