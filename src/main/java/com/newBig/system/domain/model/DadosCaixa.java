package com.newBig.system.domain.model;
import java.time.LocalDate;
import java.time.LocalTime;

public class DadosCaixa {
    private int id;
    private float valorAbertura;
    private float valorFechamento;
    private int idUsuarioAbertura;
    private int idUsuarioFechamento;
    private float valorSangria;
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
