package com.newBig.system.repository;

import com.newBig.system.model.Sale;

import java.util.List;

public interface SaleInterface {

    void save(Sale sale);

    Sale update(Sale sale);

    List<Sale> findAll();

    Sale searchById(Long id);
}
