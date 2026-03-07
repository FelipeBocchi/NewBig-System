package com.newBig.system.presentation.controller;

import com.newBig.system.application.usecase.RegisterProductUseCase;
import com.newBig.system.domain.model.Product;

import java.util.List;

public class ProductController {

    private RegisterProductUseCase useCase;

    public ProductController(RegisterProductUseCase useCase) {
        this.useCase = useCase;
    }

    public void register(String department, String category, String productName, String sku, int barcode, double price, int stock){
        useCase.execute(department, category, productName, sku, barcode, price, stock);
    }

    public List<Product> list(){
        return useCase.listar();
    }
}
