package com.newBig.system.service;

import com.newBig.system.repository.SalesMovementInterface;

public class SaleMovementService {

    private SalesMovementInterface repository;

    public SaleMovementService(SalesMovementInterface repository) {
        this.repository = repository;
    }


}
