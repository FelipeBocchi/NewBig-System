package com.newBig.system.repository;

import com.newBig.system.model.Product;
import com.newBig.system.model.SalesMovement;

import java.util.List;

public interface SalesMovementInterface {

    void save(SalesMovement movement);

    List<SalesMovement> findAll();

    Product searchById(Long id);

    List<SalesMovement> findById(Long id);
}
