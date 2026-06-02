package com.newBig.system.controller.batch.dto;

import java.time.LocalDate;

public record BatchSummaryDto(
        Long id,
        char series,
        String productName,
        Integer amount,
        LocalDate validity
) {
}
