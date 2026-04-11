package com.newBig.system.domain.repository;

import com.newBig.system.domain.model.Product;
import com.newBig.system.domain.model.Sale;

import java.util.List;
import java.util.UUID;

public interface SalesRepository {

    void save(Sale sale);

    List<Sale> findAll();

    Sale searchById(Long id);

}
