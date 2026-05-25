package com.newBig.system.repository;

import com.newBig.system.model.Batch;

import java.util.List;

public interface BatchInterface {

    void save(Batch batch);

    void delete(Batch batch);

    List<Batch> findAll();

    List<Batch> findById(Long productID);

    Batch searchById(Long batchId);

    List<Batch> joinBatchAndProduct(Long productId);

}
