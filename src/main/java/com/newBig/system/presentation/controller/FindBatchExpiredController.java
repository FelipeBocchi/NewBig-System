package com.newBig.system.presentation.controller;

import com.newBig.system.application.usecase.FindBatchExpired;
import com.newBig.system.domain.model.Batch;
import com.newBig.system.domain.repository.StockRepository;

import java.util.List;

public class FindBatchExpiredController {

    private FindBatchExpired findBatchExpired;

    //  = No controller estou estanciando um UseCase e passar o Estoque para meu encapsulamento private
    public FindBatchExpiredController(StockRepository repository) {
        this.findBatchExpired = new FindBatchExpired(repository);
    }

    public List<Batch> execute() {
        return findBatchExpired.execute();
    }
}
