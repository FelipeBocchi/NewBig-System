package com.newBig.system.model.service.batch;

import com.newBig.system.model.entity.Batch;
import com.newBig.system.model.entity.Product;

import java.time.LocalDate;
import java.util.List;

public interface BatchServiceInterface {

    void arrivalBatch(Product product, LocalDate validity, int amount, char series);

    void deleteExpired();

    void deleteZero(Batch batch);

    List<Batch> findAll();

    List<Batch> findByProduct(Long id);

    Batch searchById(Long id);

}
