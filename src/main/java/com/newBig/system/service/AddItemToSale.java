package com.newBig.system.service;

import com.newBig.system.model.Batch;
import com.newBig.system.model.Sale;
import com.newBig.system.model.SalesMovement;
import com.newBig.system.model.StockMovement;
import com.newBig.system.repository.BatchInterface;
import com.newBig.system.repository.SaleInterface;
import com.newBig.system.repository.SalesMovementInterface;
import com.newBig.system.repository.StockMovementInterface;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class AddItemToSale {

    private SaleInterface repositorySale;
    private BatchInterface repositoryBatch;
    private StockMovementInterface repositoryStockMovement;
    private SalesMovementInterface repositorySalesMovement;

    public AddItemToSale(SaleInterface repositorySale, BatchInterface repositoryBatch, StockMovementInterface repositoryStockMovement, SalesMovementInterface repositorySalesMovement) {
        this.repositorySale = repositorySale;
        this.repositoryBatch = repositoryBatch;
        this.repositoryStockMovement = repositoryStockMovement;
        this.repositorySalesMovement = repositorySalesMovement;
    }

    public void bip() {

    }

    public void logic(Long saleId, Long productId, int quantity) {

        Sale sale = repositorySale.searchById(saleId);

        //  = transfor id em codebar

        List<Batch> batchs = repositoryBatch.joinBatchAndProduct(productId);

        List<Batch> batchSell = sell(batchs, productId, quantity);

        for (Batch b : batchSell) {

            StockMovement stockMovement = new StockMovement("SAIDA", b, quantity, b.getProduct().getSalePrice());
            repositoryStockMovement.saveMovement(stockMovement);

            SalesMovement salesMovement = new SalesMovement(sale, stockMovement);
            repositorySalesMovement.save(salesMovement);
        }

    }

    private List<Batch> sell(List<Batch> batchs, Long idProduct, int quantity) {

        //  = vai guardar os lotes vendidos para depois farzemos as movimentações
        List<Batch> batchSell = new ArrayList<>();

        // Filtragem FEFO (First Expired, First Out)
        List<Batch> batchProduct = batchs.stream()
                .filter(l -> l.getProduct().getId().equals(idProduct))
                .filter(l -> !l.isExpired())
                .sorted(Comparator.comparing(Batch::getValidity))
                .toList();

        int amountBuy = quantity;
        int available = 0;
        for (Batch b : batchProduct) {
            available += b.getAmount();
        }

        // se meu usuario quer 50 e só tenho 40 vai cair aqui
        if (available < amountBuy) {
            throw new RuntimeException("Estoque insuficiente! temos " + available + " desse produto no estoque.");
        }

        for (Batch b : batchProduct) {
            // Pare se a quantidade a comprar for 0 ou menor
            if (amountBuy <= 0) break;

            int amountProduct = b.getAmount();

            if (amountProduct <= amountBuy) {
                // Se o lote tem menos ou igual ao que eu preciso, esvazio o lote
                amountBuy -= amountProduct;
                b.setAmount(0);
                batchSell.add(b);
            } else {
                // Se o lote tem mais do que eu preciso, tiro só o necessário
                b.setAmount(amountProduct - amountBuy);
                amountBuy = 0; // Compra satisfeita
                batchSell.add(b);
            }

        }

        return batchSell;

    }


}
