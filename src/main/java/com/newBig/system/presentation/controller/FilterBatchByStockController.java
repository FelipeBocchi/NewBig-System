package com.newBig.system.presentation.controller;

import com.newBig.system.application.usecase.FilterBatchByStock;
import com.newBig.system.domain.model.Batch;
import com.newBig.system.domain.repository.ProductRepository;
import com.newBig.system.domain.repository.StockRepository;

import java.util.List;

public class FilterBatchByStockController {

    private FilterBatchByStock filterBatchByStock;

    public FilterBatchByStockController(StockRepository stockRepository, ProductRepository productRepository) {
        this.filterBatchByStock = new FilterBatchByStock(stockRepository, productRepository);
    }

    public List<Batch> execute() {
        return filterBatchByStock.execute();
    }
}
