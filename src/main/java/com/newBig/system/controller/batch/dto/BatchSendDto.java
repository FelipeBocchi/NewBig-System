package com.newBig.system.controller.batch.dto;

import java.time.LocalDate;

public record BatchSendDto(
        char serie,
        int barCade,
        int amount,
        LocalDate data
) {
}
