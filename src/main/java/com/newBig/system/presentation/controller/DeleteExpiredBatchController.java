package com.newBig.system.presentation.controller;

import com.newBig.system.application.usecase.DeleteExpiredBatch;
import com.newBig.system.domain.repository.StockRepository;

public class DeleteExpiredBatchController {

    private DeleteExpiredBatch deleteExpiredBatch;

    public DeleteExpiredBatchController(StockRepository repository) {
        this.deleteExpiredBatch = new DeleteExpiredBatch(repository);
    }

    public void execute() {
        deleteExpiredBatch.execute();
    }
}
