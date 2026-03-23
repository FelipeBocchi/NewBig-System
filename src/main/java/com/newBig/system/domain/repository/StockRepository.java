package com.newBig.system.domain.repository;

import com.newBig.system.domain.model.Stock;

public interface StockRepository {

    Stock get();

    void save(Stock stock);

}
