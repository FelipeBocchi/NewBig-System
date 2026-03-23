package com.newBig.system.domain.model;

import com.newBig.system.domain.repository.ProductRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class Batch {

    private UUID id;
    private char series;

    private final UUID idProduct;

    private int amount;

    private final LocalDate validity;

    private ProductRepository repository;

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

    public BigDecimal calcTotal(UUID idProduct) {

        List<Product> products = repository.findAll();
        Product product = (Product) products.stream().filter(p -> p.getId().equals(idProduct)).toList();

        return product.getSalePrice();
    }

    public UUID getId() { return id; }

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
