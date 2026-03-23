package com.newBig.system.application.usecase;

import com.newBig.system.domain.model.Batch;
import com.newBig.system.domain.model.Stock;
import com.newBig.system.domain.repository.StockMovementRepository;
import com.newBig.system.domain.repository.StockRepository;

import java.time.LocalDate;
import java.util.UUID;

public class RegisterArrivalBatch {

    private StockRepository repository;
    private StockMovementRepository movementRepository;

    public RegisterArrivalBatch(StockRepository repository, StockMovementRepository movementRepository) {
        this.repository = repository;
        this.movementRepository = movementRepository;
    }

    public void execute(UUID idProduct, LocalDate validity, int amount, char series) {

        Stock stock = repository.get();

        for( Batch b : stock.findAll()) {
            if(b.getSeries() == series) { throw new IllegalArgumentException("Caractere já existe"); }
        }

        Batch batch = new Batch(idProduct, validity, amount, series);
        stock.saveBatch(batch);

        repository.save(stock);
    }
}
