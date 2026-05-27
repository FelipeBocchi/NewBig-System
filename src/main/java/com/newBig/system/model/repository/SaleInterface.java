package com.newBig.system.model.repository;

import com.newBig.system.model.entity.Sale;

import java.util.List;

public interface SaleInterface {

    void save(Sale sale);

    Sale update(Sale sale);

    List<Sale> findAll();

    Sale searchById(Long id);
}
