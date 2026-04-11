package com.newBig.system.domain.repository;

import com.newBig.system.domain.model.Sale;

import java.util.List;

public interface SalesRepository {

    void save(Sale sale);

    List<Sale> findAll();

}
