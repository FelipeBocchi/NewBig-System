package com.newBig.system.domain.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "stock_movement")
public class StockMovement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "id_batch", nullable = false)
    private Batch batch;

    @Column(name = "type")
    private String type;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "value")
    private BigDecimal value;

    @Column(name = "date")
    private LocalDateTime date;

    //  = Construtor protegido para o JPA
    protected StockMovement() {}

    public StockMovement(String type, Batch idBatch, int quantity, BigDecimal value) {
        this.type = type;
        this.batch = idBatch;
        this.quantity = quantity;
        this.value = value;
        this.date = LocalDateTime.now();
    }

    public String getType() {
        return type;
    }

    public Batch getIdBatch() {
        return batch;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getValue() {
        return value;
    }

    public LocalDateTime getDate() {
        return date;
    }
}
