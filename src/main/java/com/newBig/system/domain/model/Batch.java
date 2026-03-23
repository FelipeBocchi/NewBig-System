package com.newBig.system.domain.model;

import java.time.LocalDate;
import java.util.UUID;

public class Batch {

    private UUID id;
    private char series;

    private final UUID idProduct;

    private int amount;

    private final LocalDate validity;

    public Batch(UUID idProduct, LocalDate validity, int amount, char series) {
        if( amount <= 0) throw new IllegalArgumentException("Quantidade de produtos não poder ser igual ou menor que zero!!!");

        this.series = series;
        this.idProduct = idProduct;
        this.amount = amount;
        this.validity = validity;
    }

    public boolean isExpired() {
        return validity.isBefore(LocalDate.now());
    }

    public boolean willExpired() {
        return validity.isBefore(LocalDate.now().plusMonths(1));
    }

    public UUID getIdProduct() {
        return idProduct;
    }

    public char getSeries() { return  series; }

    public int getAmount() {
        return amount;
    }

    public LocalDate getValidity() {
        return validity;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
