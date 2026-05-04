package com.newBig.system.service;

import com.newBig.system.model.Batch;
import com.newBig.system.model.Product;
import com.newBig.system.repository.BatchInterface;
import com.newBig.system.repository.ProductInterface;
import com.newBig.system.repository.StockMovementInterface;

import java.time.LocalDate;
import java.util.List;

public class BatchService {

    private BatchInterface repositoryBatch;
    private ProductInterface repositoryProduct;
    private StockMovementInterface repositoryStockMovement;

    public BatchService(BatchInterface repositoryBatch, ProductInterface repositoryProduct, StockMovementInterface repositoryStockMovement) {
        this.repositoryBatch = repositoryBatch;
        this.repositoryProduct = repositoryProduct;
        this.repositoryStockMovement = repositoryStockMovement;
    }

    public void arrivalBatch(Long idProduct, LocalDate validity, int amount, char series) {

        List<Batch> findAllBatch = repositoryBatch.findAll();
        // stock

        if(validity.isBefore(LocalDate.now()) ) { throw new IllegalArgumentException("Validade não pode já estar invalida!"); }

        for(Batch b : findAllBatch) {
            if(b.getSeries() == series) { throw new IllegalArgumentException("Caractere já existe"); }
        }

        Product product = repositoryProduct.searchById(idProduct);

        Batch batch = new Batch(product, validity, amount, series);
        repositoryBatch.save(batch);
        // salvar no stock

        CreateStockMovement createStockMovement = new CreateStockMovement();
        createStockMovement.execute(batch, "ENTRADA", amount, repositoryStockMovement);
    }

    //  = Regra de negócio -> Nunca se deleta uma batch, só se ela estiver vencida ou zerada
    private void delete(Batch batch) { repositoryBatch.delete(batch); }

    //  = !!! Melhoria futura: fazer um query para pegar as batch vencidas
    public void deleteExpired() {

        List<Batch> allBatch = repositoryBatch.findAll();

        for (Batch b : allBatch) {
            if (b.isExpired()) { delete(b); }
        }

    }

    public void deleteZero(Batch batch) {

        if (batch.getAmount() == 0) { delete(batch); }
    }

    public List<Batch> findByProduct(Long id) {
        return repositoryBatch.findById(id);
    }

}
