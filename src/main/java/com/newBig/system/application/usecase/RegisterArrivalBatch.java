package com.newBig.system.application.usecase;

import com.newBig.system.domain.model.Batch;
import com.newBig.system.domain.model.Stock;
import com.newBig.system.domain.model.StockMovement;
import com.newBig.system.domain.repository.ProductRepository;
import com.newBig.system.domain.repository.StockMovementRepository;
import com.newBig.system.domain.repository.StockRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class RegisterArrivalBatch {

    private StockRepository repository;
    private StockMovementRepository movementRepository;

    public RegisterArrivalBatch(StockRepository repository, StockMovementRepository movementRepository) {
        this.repository = repository;
        this.movementRepository = movementRepository;
    }

    public void execute(UUID idProduct, LocalDate validity, int amount, char series, ProductRepository productRepository) {

        Stock stock = repository.get();

        if(validity.isBefore(LocalDate.now()) ) { throw new IllegalArgumentException("Validade não pode já estar invalida!"); }

        for( Batch b : stock.findAll()) {
            if(b.getSeries() == series) { throw new IllegalArgumentException("Caractere já existe"); }
        }

        Batch batch = new Batch(idProduct, validity, amount, series, productRepository);
        stock.saveBatch(batch);

        /*String type, UUID idBatch, UUID idProduct, int quantity, BigDecimal value
        UUID idBatch = batch.getId();
        BigDecimal total = batch.calcTotal(idProduct);
        StockMovement movement = new StockMovement("ENTRADA", idBatch, idProduct, amount, total);
        movementRepository.saveMovement(movement);
        */
        CreateStockMovement create = new CreateStockMovement();
        create.execute(batch, "Entrada", idProduct, amount, movementRepository);

        repository.save(stock);
    }
}
