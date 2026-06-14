package com.newBig.system.controller.product.dto;

import com.newBig.system.model.entity.Product;

import java.math.BigDecimal;

public record ProductSummaryDto(
        int barcode,
        String productName,
        String category,
        BigDecimal price,
        Product.UnitType unit,
        Product.ProductType status
) {
}
