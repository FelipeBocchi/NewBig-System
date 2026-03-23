package com.newBig.system.application.usecase;

import com.newBig.system.domain.model.Batch;
import com.newBig.system.domain.model.Stock;
import com.newBig.system.domain.repository.StockMovementRepository;
import com.newBig.system.domain.repository.StockRepository;

import java.util.UUID;

public class BuyOfBatch {

    private StockRepository repository;
    private StockMovementRepository movementRepository;

    public BuyOfBatch(StockRepository repository, StockMovementRepository movementRepository) {
        this.repository = repository;
        this.movementRepository = movementRepository;
    }

    public void execute(UUID idProduct, int quantity) {

        Stock stock = repository.get();

        stock.buy(idProduct, quantity);

        // == Vai criar uma movimentação a cada lote vendido para ficarem tudos registados
        for (Batch b : stock.getBatchesBuy()) {
            CreateStockMovement create = new CreateStockMovement();
            create.execute( b, "SAIDA", idProduct, quantity, movementRepository);
        }

        repository.save(stock);
    }
}
