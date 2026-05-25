package com.newBig.system.service;

import com.newBig.system.model.Batch;
import com.newBig.system.model.StockMovement;
import com.newBig.system.repository.StockMovementInterface;

import java.math.BigDecimal;

public class CreateStockMovement {

    public void execute(Batch batch, String typo, int amount, StockMovementInterface movementRepository) {

        BigDecimal subtotal = batch.getProduct().getSalePrice();
        BigDecimal total = subtotal.multiply(BigDecimal.valueOf(amount));
        StockMovement movement = new StockMovement(typo, batch, amount, total);
        movementRepository.saveMovement(movement);
    }

}
