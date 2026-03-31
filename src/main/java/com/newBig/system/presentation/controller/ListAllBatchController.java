package com.newBig.system.presentation.controller;

import com.newBig.system.application.usecase.ListAllBatch;
import com.newBig.system.domain.model.Batch;
import com.newBig.system.domain.repository.StockRepository;

import java.util.List;

public class ListAllBatchController {

    private ListAllBatch usecase = new ListAllBatch();

    /*public ListAllBatchController(StockRepository usecase) {
        this.usecase = usecase;
    }*/

    public List<Batch> execute(StockRepository stockRepository) {
        return usecase.execute( stockRepository);
    }
}
