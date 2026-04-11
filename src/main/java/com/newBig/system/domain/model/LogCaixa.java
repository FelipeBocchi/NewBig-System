package com.newBig.system.domain.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity
@Table(name = "logs_caixa")
public class LogCaixa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descricao", nullable = false, length = 100)
    private String descricao;

    @Column(name = "data")
    private LocalDateTime data;

    public LogCaixa(){};

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDateTime getData() {
        return data;
    }


}