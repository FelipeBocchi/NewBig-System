package com.newBig.system.application.usecase;

import com.newBig.system.domain.model.Batch;
import com.newBig.system.domain.repository.StockRepository;

import java.util.List;

public class ListAllBatch {

    //private StockRepository stockRepository;

    /*public ListAllBatch(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }*/

    public List<Batch> execute( StockRepository stockRepository) {

        //Stock stock = stockRepository.get();

        return stockRepository.findAll();
    }
}
