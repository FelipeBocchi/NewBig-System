package com.newBig.system.domain.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;


public class Stock {

    private List<Batch> batchs = new ArrayList<>();
    private List<Batch> batchesBuy = new ArrayList<>();

    public Stock(List<Batch> batchsFromDatabase) {
        this.batchs = batchsFromDatabase;
    }

    public void saveBatch(Batch batch) {
        batchs.add(batch);
    }

    public void deleteBatchExpired() {

        batchs.removeIf(Batch::isExpired);
    }

    public List<Batch> findAll() { return batchs; }

    public void buy(UUID idProduct, int amount) {
        // Inicialize como uma lista vazia
        this.batchesBuy = new ArrayList<>();

        // Filtragem FEFO (First Expired, First Out)
        List<Batch> batchProduct = batchs.stream()
                .filter(l -> l.getProduct().getId().equals(idProduct))
                .filter(l -> !l.isExpired())
                .sorted(Comparator.comparing(Batch::getValidity))
                .toList();

        int amountBuy = amount;
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
                batchesBuy.add(b);
            } else {
                // Se o lote tem mais do que eu preciso, tiro só o necessário
                b.setAmount(amountProduct - amountBuy);
                amountBuy = 0; // Compra satisfeita
                batchesBuy.add(b);
            }
        }
    }

    public List<Batch> getBatchesBuy() { return batchesBuy; }

    public int getTotalQuantity(UUID idProduct) {

        int total = 0;
        for( Batch b: batchs) {
            if (b.getProduct().getId().equals(idProduct)) total += b.getAmount();
        }

        return total;
    }

    public boolean isLowStock(UUID idProduct, int minimumStock) {

        int quantity = 0;
        for( Batch b : batchs){
            if(b.getProduct().getId().equals(idProduct)) quantity += b.getAmount();
        }

        return quantity <= minimumStock;
    }

    public boolean isOutOfStock(UUID idProduct) {

        int quantity = 0;
        for( Batch b : batchs){
            if(b.getProduct().getId().equals(idProduct)) quantity += b.getAmount();
        }

        return quantity == 0;
    }

    public List<Batch> batchesExpired() {
        return batchs.stream().filter(Batch::isExpired)
                .toList();
    }

    public List<Batch> searchByValidity(int day) {

        return batchs.stream().filter( b -> b.getValidity().isBefore(LocalDate.now().plusDays(day)))
                .toList();
    }


}
