package com.newBig.system.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "batch")
public class Batch {

    // id gerado automatico
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "series")
    private char series;

    // fk = Varios lotes podem ser de um único produto
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "amount", nullable = false )
    private int amount;

    @Column(name = "validity")
    private LocalDate validity;



    //  = Construtor protegido para o JPA
    public Batch() {}



    public Batch(Product product, LocalDate validity, int amount, char series) {
        if( amount <= 0) throw new IllegalArgumentException("Quantidade de produtos não poder ser igual ou menor que zero!!!");

        this.series = series;
        this.product = product;
        this.amount = amount;
        this.validity = validity;
    }

    public boolean isExpired() {
        return validity.isBefore(LocalDate.now());
    }

    public boolean willExpired() {
        return validity.isBefore(LocalDate.now().plusMonths(1));
    }

    //  = Métodos Getting =

    public Long getId() { return id; }

    public Product getProduct() {
        return product;
    }

    public char getSeries() { return  series; }

    public int getAmount() {
        return amount;
    }

    public LocalDate getValidity() {
        return validity;
    }

    //  =

    public void setSeries(char series) {
        this.series = series;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setValidity(LocalDate validity) {
        this.validity = validity;
    }
}
