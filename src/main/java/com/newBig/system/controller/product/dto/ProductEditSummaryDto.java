package com.newBig.system.controller.product.dto;

import java.math.BigDecimal;

public record ProductEditSummaryDto(
        int barCode,
        String productName,
        String category,
        BigDecimal price
) {
}
