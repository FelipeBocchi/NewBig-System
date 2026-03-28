package com.newBig.system.domain.model;
import java.time.LocalDate;
import java.time.LocalTime;

public class DadosCaixa {
    private int id;
    private float valorAbertura;
    private float valorFechamento;
    private int idUsuarioAbertura;
    private int idUsuarioFechamento;
    private LocalDate dataAbertura;
    private LocalDate dataFechamento;
    private LocalTime horaAbertura;
    private LocalTime horaFechamento;
    private static int contadorDoId;

    public DadosCaixa() {
        contadorDoId++;
        this.id = contadorDoId;
    }

    public int getId() {
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

    public void salvarFechamento(int id, float valor){
        this.idUsuarioFechamento = id;
        this.valorFechamento = valor;
        this.dataFechamento = LocalDate.now();
        this.horaFechamento = LocalTime.now();
    }

    @Override
    public String toString() {
        return "DadosCaixa{" +
                "id=" + id +
                ", valorAbertura=" + valorAbertura +
                ", valorFechamento=" + valorFechamento +
                ", idUsuarioAbertura=" + idUsuarioAbertura +
                ", idUsuarioFechamento=" + idUsuarioFechamento +
                ", dataAbertura=" + dataAbertura +
                ", dataFechamento=" + dataFechamento +
                ", horaAbertura=" + horaAbertura +
                ", horaFechamento=" + horaFechamento +
                '}';

    }
}
