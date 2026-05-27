package com.newBig.system.model.service;

import com.newBig.system.model.entity.Batch;
import com.newBig.system.model.entity.StockMovement;
import com.newBig.system.model.repository.stockMovement.StockMovementInterface;

import java.math.BigDecimal;

public class CreateStockMovement {

    public void execute(Batch batch, String typo, int amount, StockMovementInterface movementRepository) {

        BigDecimal subtotal = batch.getProduct().getSalePrice();
        BigDecimal total = subtotal.multiply(BigDecimal.valueOf(amount));
        StockMovement movement = new StockMovement(typo, batch, amount, total);
        movementRepository.saveMovement(movement);
    }

}
