package com.newBig.system.controller.sale.dto;

import java.math.BigDecimal;

public record SaleSummaryDto(
        int quantityItens,
        Long idBatch,
        String nameProduct,
        BigDecimal unitPrice,
        Long id
) {
}
