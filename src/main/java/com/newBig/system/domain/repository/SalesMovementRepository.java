package com.newBig.system.domain.repository;

import com.newBig.system.domain.model.Product;
import com.newBig.system.domain.model.SalesMovement;

import java.util.List;
import java.util.UUID;

public interface SalesMovementRepository {

    void save(SalesMovement movement);

    List<SalesMovement> findAll();

    Product searchById(UUID id);
}
