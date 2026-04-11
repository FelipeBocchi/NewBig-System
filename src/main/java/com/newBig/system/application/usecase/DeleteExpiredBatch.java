package com.newBig.system.application.usecase;

import com.newBig.system.domain.model.Batch;
import com.newBig.system.domain.model.Stock;
import com.newBig.system.domain.repository.StockRepository;

import java.util.List;

public class DeleteExpiredBatch {

    private StockRepository repository;

    public DeleteExpiredBatch(StockRepository repository) {
        this.repository = repository;
    }

    public void execute() {

        //  = Primeiro acesso o estoque na memória, modifico o estoque por fim salvo e Estoque atual.

        List<Batch> findAllBatch = repository.findAll();
        Stock stock = new Stock(findAllBatch);

        stock.deleteBatchExpired();

        for (Batch b : stock.findAll())
            repository.save(b);
    }

}
