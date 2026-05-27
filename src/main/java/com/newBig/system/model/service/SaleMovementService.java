package com.newBig.system.model.service;

import com.newBig.system.model.entity.SalesMovement;
import com.newBig.system.model.repository.SalesMovementInterface;

import java.util.List;

public class SaleMovementService {

    private SalesMovementInterface repository;

    public SaleMovementService(SalesMovementInterface repository) {
        this.repository = repository;
    }

    public List<SalesMovement> findAll() {
        return repository.findAll();
    }

    public List<SalesMovement> findById(Long idSale) {
        return repository.findById(idSale);
    }
}
