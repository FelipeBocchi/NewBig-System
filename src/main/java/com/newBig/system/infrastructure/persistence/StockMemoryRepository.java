package com.newBig.system.infrastructure.persistence;

import com.newBig.system.domain.model.Stock;
import com.newBig.system.domain.repository.StockRepository;

public class StockMemoryRepository implements StockRepository {

    private Stock stock = new Stock();

    @Override
    public Stock get() {
        return stock;
    }

    @Override
    public void save(Stock stock) {
        this.stock = stock;
    }
}
