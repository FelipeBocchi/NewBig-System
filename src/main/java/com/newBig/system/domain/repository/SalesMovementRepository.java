package com.newBig.system.domain.repository;

import com.newBig.system.domain.model.Sale;
import com.newBig.system.domain.model.SalesMovement;

import java.util.List;

public interface SalesMovementRepository {

    void save(SalesMovement movement);

    List<SalesMovement> findAll();
}
