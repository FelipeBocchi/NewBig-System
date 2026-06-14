package com.newBig.system.controller.product.impl;

import com.newBig.system.controller.product.ProductControllerInterface;
import com.newBig.system.controller.product.dto.ProductEditSummaryDto;
import com.newBig.system.controller.product.dto.ProductSummaryDto;
import com.newBig.system.model.entity.Product;
import com.newBig.system.model.service.product.ProductServiceInterface;

import javax.swing.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ProductControllerImpl implements ProductControllerInterface {

    private ProductServiceInterface productService;

    public ProductControllerImpl(ProductServiceInterface productService) {
        this.productService = productService;
    }

    public ProductControllerImpl() {
    }

    @Override
    public List<ProductSummaryDto> listAll() {

        List<Product> productList = productService.findAll();
        List<ProductSummaryDto> summaryDtoList = new ArrayList<>();

        for (Product p : productList) {
            summaryDtoList.add(new ProductSummaryDto(p.getBarcode(), p.getProductName(), p.getCategory(), p.getSalePrice(), p.getUnit(), p.getType()));
        }

        return summaryDtoList;

    }

    @Override
    public void editProduct(ProductEditSummaryDto summaryDto) {

        //  = achamos o product pelo código de barra
        Product product = productService.findByBarcode(summaryDto.barCode());

        //  = alteramos o que tem que alterar
        product.setProductName(summaryDto.productName());
        product.setCategory(summaryDto.category());
        product.setSalePrice(summaryDto.price());

        //  = damos um update no banco
        productService.update(product);
    }

    @Override
    public void deleteProduct(int barCode) {

        Product product = productService.findByBarcode(barCode);

        if (product == null) {
            throw new IllegalArgumentException("Produto não encontrado no sistema.");
        }

        productService.delete(product);

    }

    @Override
    public void salveProduct(ProductEditSummaryDto summaryDto) {

        productService.save(
                summaryDto.productName(),
                "Produto sem descrição padrão",
                "Padrão",
                summaryDto.category(),
                summaryDto.barCode(),
                BigDecimal.ZERO,
                summaryDto.price(),
                10,
                Product.ProductType.PRODUCT,
                Product.UnitType.UNIT
        );

    }
}
