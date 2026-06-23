package com.newBig.system.controller.sale.dto;

import java.math.BigDecimal;

public record SaleMovementDto(
        BigDecimal value,
        int quantity
) {
}
