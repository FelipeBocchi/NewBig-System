package com.newBig.system.domain.repository;

import com.newBig.system.domain.model.Batch;
import com.newBig.system.domain.model.Stock;

import java.util.List;
import java.util.UUID;

public interface StockRepository {

    void save(Batch batch);

    List<Batch> findAll();

    List<Batch> findById(UUID productID);


}
