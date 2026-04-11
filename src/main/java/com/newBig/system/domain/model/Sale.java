package com.newBig.system.domain.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "sale")
public class Sale {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "start_time", nullable = false)
    private LocalDateTime startTime;

    //cliente
    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    //funcionario
    @ManyToOne
    @JoinColumn(name = "funcionario_id", nullable = false)
    private  Funcionario funcionario;

    @Column(name = "total", precision = 10, scale = 2)
    private BigDecimal total;

    @Column(name = "payment_method", nullable = false)
    private String paymentMethod;

    @Column(name = "status", nullable = false)
    private String status;

    @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SalesMovement> movements;

    protected Sale() {}

    public Sale(LocalDateTime startTime, Cliente cliente, Funcionario funcionario, BigDecimal total, String paymentMethod, String status, List<SalesMovement> movements) {
        this.startTime = startTime;
        this.cliente = cliente;
        this.funcionario = funcionario;
        this.total = total;
        this.paymentMethod = paymentMethod;
        this.status = status;
        this.movements = movements;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public String getStatus() {
        return status;
    }

    public List<SalesMovement> getMovements() {
        return movements;
    }

    public Long getId() {
        return id;
    }
}
