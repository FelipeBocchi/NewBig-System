package com.newBig.system.model.repository.saleMovement;

import com.newBig.system.model.entity.Product;
import com.newBig.system.model.entity.SalesMovement;

import java.util.List;

public interface SalesMovementInterface {

    void save(SalesMovement movement);

    List<SalesMovement> findAll();

    Product searchById(Long id);

    List<SalesMovement> findById(Long id);
}
