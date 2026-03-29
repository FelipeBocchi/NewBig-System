package com.newBig.system.presentation.controller;

import com.newBig.system.application.usecase.ListAllMovement;
import com.newBig.system.domain.model.StockMovement;
import com.newBig.system.domain.repository.StockMovementRepository;

import java.util.List;

public class ListAllMovementController {

    private ListAllMovement usecase = new ListAllMovement();

    public List<StockMovement> execute(StockMovementRepository stockMovementRepository) {

        return usecase.execute(stockMovementRepository);
    }
}
