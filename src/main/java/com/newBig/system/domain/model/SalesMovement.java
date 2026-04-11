package com.newBig.system.domain.model;

import jakarta.persistence.*;

@Entity
@Table(name = "sale_movement")
public class SalesMovement {
    //  = Class criada para servir de intermediario entre venda e movimentação

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sale_id", nullable = false )
    private Sale sale;

    @OneToOne( cascade = CascadeType.ALL)
    @JoinColumn(name = "stock_movement_id", nullable = false)
    private StockMovement stockMovement;

    protected SalesMovement() {}

    public SalesMovement( Sale sale, StockMovement stockMovement) {
        this.sale = sale;
        this.stockMovement = stockMovement;
    }

    public Long getId() {
        return id;
    }

    public Sale getSale() {
        return sale;
    }

    public StockMovement getStockMovement() {
        return stockMovement;
    }
}
