package com.newBig.system.domain.repository;

import com.newBig.system.domain.model.StockMovement;

import java.time.LocalDate;
import java.util.List;

public interface StockMovementRepository {

    void saveMovement(StockMovement stockMovement);

    List<StockMovement> searchByTime(LocalDate day);

    List<StockMovement> findAll();
}
