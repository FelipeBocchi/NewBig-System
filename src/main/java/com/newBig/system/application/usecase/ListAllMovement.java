package com.newBig.system.application.usecase;

import com.newBig.system.domain.model.Stock;
import com.newBig.system.domain.model.StockMovement;
import com.newBig.system.domain.repository.StockMovementRepository;

import java.util.List;

public class ListAllMovement {

    public List<StockMovement> execute(StockMovementRepository stockMovementRepository) {

        return stockMovementRepository.findAll();
    }
}
