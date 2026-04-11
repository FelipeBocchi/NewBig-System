package com.newBig.system.domain.model;

import com.newBig.system.domain.repository.ProductRepository;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "batch")
public class Batch {

    // id gerado automatico
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name = "series")
    private char series;

    // fk
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "amount", nullable = false )
    private int amount;

    @Column(name = "validity")
    private LocalDate validity;

    // é meu array de produtos, para acessar o "banco"
   // @Column(name = "product_repository")
    //private ProductRepository repository;

    //  = Construtor protegido para o JPA
    protected Batch() {}

    public Batch(Product product, LocalDate validity, int amount, char series) {
        if( amount >= 0) throw new IllegalArgumentException("Quantidade de produtos não poder ser igual ou menor que zero!!!");

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

    public UUID getId() { return id; }

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

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
