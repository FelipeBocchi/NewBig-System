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

    public void register(String productName, String description, String department, String category, int barcode, BigDecimal costPrice, BigDecimal salePrice, int minimumStock, Product.ProductType type, Product.UnitType unit){
        useCase.execute(productName, description, department, category, barcode, costPrice, salePrice, minimumStock, type, unit);
    }

    public List<Product> list(){
        return useCase.listar();
    }

    public List<Product> listFindByCategory(String category) {
        return useCase.findCategory(category);
    }

    public List<Product> listFindByType(Product.ProductType type) { return useCase.findType(type); }

    public List<Product> listFindBySalePrice(BigDecimal price) { return  useCase.findSalePrice(price); }

    public List<Product> listFindByCostPrice(BigDecimal price) { return  useCase.findCostPrice(price); }

    public List<Product> listFindByEqualPrice(BigDecimal price) { return  useCase.findEqualPrice(price); }

    public List<Product> listFindByUnit(Product.UnitType unit) { return useCase.findUnit(unit); }
}
