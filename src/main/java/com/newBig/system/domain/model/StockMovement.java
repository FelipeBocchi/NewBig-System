package com.newBig.system.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class StockMovement {

    private final String type;

    private final UUID idBatch;
    private final UUID idProduct;

    private final int quantity;

    private final BigDecimal value;

    private final LocalDateTime date;

    public StockMovement(String type, UUID idBatch, UUID idProduct, int quantity, BigDecimal value) {
        this.type = type;
        this.idBatch = idBatch;
        this.idProduct = idProduct;
        this.quantity = quantity;
        this.value = value;
        this.date = LocalDateTime.now();
    }

    public String getType() {
        return type;
    }

    public UUID getIdBatch() {
        return idBatch;
    }

    public UUID getIdProduct() {
        return idProduct;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getValue() {
        return value;
    }

    public LocalDateTime getDate() {
        return date;
    }
}
