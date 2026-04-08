package com.newBig.system.infrastructure.persistence;

import com.newBig.system.domain.model.Batch;
import com.newBig.system.domain.model.Stock;
import com.newBig.system.domain.repository.StockRepository;

import jakarta.persistence.EntityManager;
import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.UUID;

public class StockMemoryRepository implements StockRepository {

    /*private Stock stock = new Stock();

    @Override
    public Stock get() {
        return stock;
    }

    @Override
    public void save(Stock stock) {
        this.stock = stock;
    }*/

    @Override
    public void save(Batch batch) {

    }

    @Override
    public List<Batch> findAll() {
        return List.of();
    }

    @Override
    public List<Batch> findById(UUID productID) {
        return List.of();
    }
}
