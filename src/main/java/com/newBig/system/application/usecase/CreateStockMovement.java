package com.newBig.system.application.usecase;

import com.newBig.system.domain.model.Batch;
import com.newBig.system.domain.model.StockMovement;
import com.newBig.system.domain.repository.StockMovementRepository;

import java.math.BigDecimal;
import java.util.UUID;

public class CreateStockMovement {

    public void execute(Batch batch, String typo, UUID idProduct, int amount, StockMovementRepository movementRepository) {

        UUID idBatch = batch.getId();
        BigDecimal subtotal = batch.calcTotal(idProduct);
        BigDecimal total = subtotal.multiply(BigDecimal.valueOf(amount));
        StockMovement movement = new StockMovement(typo, idBatch, idProduct, amount, total);
        movementRepository.saveMovement(movement);
    }
}
