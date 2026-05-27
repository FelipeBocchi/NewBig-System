package com.newBig.system.model.repository;

import com.newBig.system.model.entity.StockMovement;

import java.time.LocalDate;
import java.util.List;

public interface StockMovementInterface {

    void saveMovement(StockMovement stockMovement);

    List<StockMovement> searchByTime(LocalDate day);

    List<StockMovement> findAll();
}
