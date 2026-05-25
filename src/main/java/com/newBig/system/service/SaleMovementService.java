package com.newBig.system.service;

import com.newBig.system.model.SalesMovement;
import com.newBig.system.repository.SalesMovementInterface;

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
