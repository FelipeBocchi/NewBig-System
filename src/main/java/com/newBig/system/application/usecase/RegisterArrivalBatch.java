package com.newBig.system.application.usecase;

import com.newBig.system.domain.model.Batch;
import com.newBig.system.domain.model.Product;
import com.newBig.system.domain.model.Stock;
import com.newBig.system.domain.model.StockMovement;
import com.newBig.system.domain.repository.ProductRepository;
import com.newBig.system.domain.repository.StockMovementRepository;
import com.newBig.system.domain.repository.StockRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class RegisterArrivalBatch {

    private StockRepository stockRepository;
    private StockMovementRepository movementRepository;
    private ProductRepository productRepository;

    public RegisterArrivalBatch(StockRepository repository, StockMovementRepository movementRepository, ProductRepository productRepository) {
        this.stockRepository = repository;
        this.movementRepository = movementRepository;
        this.productRepository = productRepository;
    }

    public void execute(UUID idProduct, LocalDate validity, int amount, char series, ProductRepository productRepository) {

        //Stock stock = repository.get();
        List<Batch> findAllBatch = stockRepository.findAll();
        Stock stock = new Stock(findAllBatch);

        if(validity.isBefore(LocalDate.now()) ) { throw new IllegalArgumentException("Validade não pode já estar invalida!"); }

        for( Batch b : findAllBatch) {
            if(b.getSeries() == series) { throw new IllegalArgumentException("Caractere já existe"); }
        }

        Product product = productRepository.searchById(idProduct);

        Batch batch = new Batch(product, validity, amount, series);
        stockRepository.save(batch);
        stock.saveBatch(batch);

        /*String type, UUID idBatch, UUID idProduct, int quantity, BigDecimal value
        UUID idBatch = batch.getId();
        BigDecimal total = batch.calcTotal(idProduct);
        StockMovement movement = new StockMovement("ENTRADA", idBatch, idProduct, amount, total);
        movementRepository.saveMovement(movement);
        */
        CreateStockMovement create = new CreateStockMovement();
        create.execute(batch, "Entrada", amount, movementRepository);

        //repository.save(stock);
    }
}
