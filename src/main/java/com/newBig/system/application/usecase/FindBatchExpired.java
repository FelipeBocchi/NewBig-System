package com.newBig.system.application.usecase;

import com.newBig.system.domain.model.Batch;
import com.newBig.system.domain.model.Stock;
import com.newBig.system.domain.repository.StockRepository;

import java.util.List;

public class FindBatchExpired {

    private StockRepository repository;

    public FindBatchExpired(StockRepository repository) {
        this.repository = repository;
    }

    public List<Batch> execute() {

        Stock stock = repository.get();

        return stock.batchesExpired();
    }
}
