package com.newBig.system.domain.model;

import com.newBig.system.domain.repository.FuncionarioRepo;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "dados_caixa")
public class DadosCaixa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "valorAbertura", nullable = false)
    private double valorAbertura;

    @Column(name = "valorFechamento")
    private double valorFechamento;

    @ManyToOne
    @JoinColumn(name = "usuarioAbertura", nullable = false)
    private Funcionario usuarioAbertura;

    @ManyToOne
    @JoinColumn(name = "usuarioFechamento")
    private Funcionario usuarioFechamento;

    @Column(name = "valorSangria")
    private double valorSangria;

    @Column(name = "dataAbertura", nullable = false)
    private LocalDate dataAbertura;

    @Column(name = "dataFechamento")
    private LocalDate dataFechamento;

    @Column(name = "horaAbertura", nullable = false)
    private LocalTime horaAbertura;

    @Column(name = "horaFechamento")
    private LocalTime horaFechamento;

    @Column(name = "status", nullable = false)
    private int status;

    @Column(name = "valorAtual", nullable = false)
    private double valorAtual = 0;

    public DadosCaixa(){};

    public DadosCaixa(LocalTime horaAbertura, LocalDate dataAbertura, Funcionario funcionario, float valorAbertura) {
        this.horaAbertura = horaAbertura;
        this.dataAbertura = dataAbertura;
        this.usuarioAbertura = funcionario;
        this.valorAbertura = valorAbertura;
    }

    public Long getId() {
        return id;
    }

    public Funcionario getUsuarioAbertura() {
        return usuarioAbertura;
    }

    public double getValorAbertura() {
        return valorAbertura;
    }

    public LocalDate getDataAbertura() {
        return dataAbertura;
    }

    public LocalTime getHoraAbertura() {
        return horaAbertura;
    }

    public double getValorAtual() {
        return valorAtual;
    }

    public void salvarAbertura(Funcionario funcionario, double valor){
        this.usuarioAbertura = funcionario;
        this.valorAbertura= valor;
        this.dataAbertura = LocalDate.now();
        this.horaAbertura = LocalTime.now();
        this.status = 0;
        this.valorAtual = valor;
    }

    public void salvarFechamento(Funcionario funcionario, double valor, double sangria){
        this.usuarioFechamento = funcionario;
        this.valorFechamento = valor;
        this.valorSangria = sangria;
        this.dataFechamento = LocalDate.now();
        this.horaFechamento = LocalTime.now();
        this.status = 1;
    }

    public void setValorAtual(double valorAtual) {
        this.valorAtual = valorAtual;
    }
}
