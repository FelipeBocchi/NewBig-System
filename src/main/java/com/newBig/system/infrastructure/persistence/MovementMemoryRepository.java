package com.newBig.system.infrastructure.persistence;

import com.newBig.system.domain.model.StockMovement;
import com.newBig.system.domain.repository.StockMovementRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MovementMemoryRepository implements StockMovementRepository {

    List<StockMovement> stockMovements = new ArrayList<>();

    @Override
    public void saveMovement(StockMovement stockMovement) {
        stockMovements.add(stockMovement);
    }

    @Override
    public List<StockMovement> searchByTime(LocalDate day) {
        return stockMovements.stream().filter( s -> s.getDate().toLocalDate().equals(day))
                .toList();
    }

    @Override
    public List<StockMovement> findAll() {
        return stockMovements;
    }
}
