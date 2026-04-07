package com.newBig.system.domain.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "DadosCaixa")
public class DadosCaixa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "valorAbertura", nullable = false)
    private float valorAbertura;

    @Column(name = "valorFechamento")
    private Float valorFechamento;

    @Column(name = "idUsuarioAbertura", nullable = false)
    private int idUsuarioAbertura;

    @Column(name = "idUsuarioFechamento")
    private int idUsuarioFechamento;

    @Column(name = "valorSangria")
    private Float valorSangria;

    @Column(name = "dataAbertura", nullable = false)
    private LocalDate dataAbertura;

    @Column(name = "dataFechamento")
    private LocalDate dataFechamento;

    @Column(name = "horaAbertura", nullable = false)
    private LocalTime horaAbertura;

    @Column(name = "horaFechamento")
    private LocalTime horaFechamento;

    public DadosCaixa(){};

    public DadosCaixa(LocalTime horaAbertura, LocalDate dataAbertura, int idUsuarioAbertura, float valorAbertura) {
        this.horaAbertura = horaAbertura;
        this.dataAbertura = dataAbertura;
        this.idUsuarioAbertura = idUsuarioAbertura;
        this.valorAbertura = valorAbertura;
    }

    public Long getId() {
        return id;
    }

    public float getValorAbertura() {
        return valorAbertura;
    }

    public int getIdUsuarioAbertura() {
        return idUsuarioAbertura;
    }

    public LocalDate getDataAbertura() {
        return dataAbertura;
    }

    public LocalTime getHoraAbertura() {
        return horaAbertura;
    }

    public void salvarAbertura(int id, float valor){
        this.idUsuarioAbertura = id;
        this.valorAbertura= valor;
        this.dataAbertura = LocalDate.now();
        this.horaAbertura = LocalTime.now();
    }

    public void salvarFechamento(int id, float valor, float sangria){
        this.idUsuarioFechamento = id;
        this.valorFechamento = valor;
        this.valorSangria = sangria;
        this.dataFechamento = LocalDate.now();
        this.horaFechamento = LocalTime.now();
    }

    @Override
    public String toString() {
        return "      ---DadosCaixa---   \n" +
                "  ID do caixa: " + id + "\n" +
                "  Valor de Abertura: " + valorAbertura + "\n" +
                "  Valor de Fechamento: " + valorFechamento + "\n" +
                "  ID Usuario de Abertura: " + idUsuarioAbertura + "\n" +
                "  ID Usuario de Fechamento: " + idUsuarioFechamento + "\n" +
                "  Data de Abertura: " + dataAbertura + "\n" +
                "  Data de Fechamento: " + dataFechamento + "\n" +
                "  Hora de Abertura: " + horaAbertura + "\n" +
                "  Hora de Fechamento: " + horaFechamento + "\n" +
                "}";

    }
}
