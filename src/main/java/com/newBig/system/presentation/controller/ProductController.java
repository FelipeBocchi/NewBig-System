package com.newBig.system.presentation.controller;

import com.newBig.system.application.usecase.RegisterProductUseCase;
import com.newBig.system.domain.model.Product;

import java.math.BigDecimal;
import java.util.List;

public class ProductController {

    private RegisterProductUseCase useCase;

    public ProductController(RegisterProductUseCase useCase) {
        this.useCase = useCase;
    }

    public void register(String productName, String description, String department, String category, String sku, int barcode, BigDecimal costPrice, BigDecimal salePrice, int stock, int minimumStock, Product.ProductType type, Product.UnitType unit){
        useCase.execute(productName, description, department, category, sku, barcode, costPrice, salePrice, stock, minimumStock, type, unit);
    }

    public List<Product> list(){
        return useCase.listar();
    }

    public List<Product> listFindByCategory(String category) {
        return useCase.findCategory(category);
    }
}
