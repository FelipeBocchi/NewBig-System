package com.newBig.system.application.usecase;

import com.newBig.system.domain.model.Batch;
import com.newBig.system.domain.model.Stock;
import com.newBig.system.domain.repository.StockMovementRepository;
import com.newBig.system.domain.repository.StockRepository;
import com.newBig.system.infrastructure.persistence.StockRepositoryImpl;

import java.util.List;
import java.util.UUID;

public class BuyOfBatch {

    private StockRepository repository;
    private StockMovementRepository movementRepository;

    private StockRepositoryImpl stockRepository;

    public BuyOfBatch(StockRepository repository, StockMovementRepository movementRepository) {
        this.repository = repository;
        this.movementRepository = movementRepository;
    }

    public void execute(UUID idProduct, int quantity) {

        List<Batch> findAllBatchOfProduct = stockRepository.findById(idProduct);

        Stock stock = new Stock(findAllBatchOfProduct);

        stock.buy(idProduct, quantity);

        // == Vai criar uma movimentação a cada lote vendido para ficarem tudos registados
        for (Batch b : stock.getBatchesBuy()) {
            CreateStockMovement create = new CreateStockMovement();
            create.execute( b, "SAIDA", quantity, movementRepository);

            stockRepository.save(b);
        }

        //  = será que preciso salvar as alterações que fiz no bando no stock?
        //repository.save(stock);
    }
}
