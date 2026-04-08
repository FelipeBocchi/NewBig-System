package com.newBig.system.application.usecase;

import com.newBig.system.domain.model.Batch;
import com.newBig.system.domain.model.StockMovement;
import com.newBig.system.domain.repository.StockMovementRepository;

import java.math.BigDecimal;
import java.util.UUID;

public class CreateStockMovement {

    public void execute(Batch batch, String typo, int amount, StockMovementRepository movementRepository) {

        BigDecimal subtotal = batch.getProduct().getSalePrice();
        BigDecimal total = subtotal.multiply(BigDecimal.valueOf(amount));
        StockMovement movement = new StockMovement(typo, batch, amount, total);
        movementRepository.saveMovement(movement);
    }
}
