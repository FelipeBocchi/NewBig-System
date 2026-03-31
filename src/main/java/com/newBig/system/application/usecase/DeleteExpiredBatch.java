package com.newBig.system.application.usecase;

import com.newBig.system.domain.model.Stock;
import com.newBig.system.domain.repository.StockRepository;

public class DeleteExpiredBatch {

    private StockRepository repository;

    public DeleteExpiredBatch(StockRepository repository) {
        this.repository = repository;
    }

    public void execute() {

        //  = Primeiro acesso o estoque na memória, modifico o estoque por fim salvo e Estoque atual.

        Stock stock = repository.get();

        stock.deleteBatchExpired();

        repository.save(stock);
    }

}
