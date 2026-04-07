package com.newBig.system.domain.model;

import jakarta.persistence.*;

@Entity
@Table(name = "cliente")
public class Cliente{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "cpf", nullable = false, unique = true, length = 15)
    private String cpf;

    @Column(name = "cep", nullable = false)
    private String cep;

    @Column(name = "rua", nullable = false)
    private String rua;

    @Column(name = "numero", nullable = false)
    private int numero;

    @Column(name = "bairro", nullable = false)
    private String bairro;

    @Column(name = "telefone", nullable = false)
    private String telefone;

    public Cliente(){};
    public Cliente(String nome, String cpf, String cep, String rua, int numero, String bairro, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.cep = cep;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.telefone = telefone;
    }


//    Getters

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getCep() {
        return cep;
    }

    public String getRua() {
        return rua;
    }

    public int getNumero() {
        return numero;
    }

    public String getBairro() {
        return bairro;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getDadosCliente(){
        return String.format(
                "\n CEP: %-20s" +
                        "\n Rua: %-20s" +
                        "\n Numero: %-20d" +
                        "\n Bairro: %-20s" +
                        "\n Telefone: %-20s",
                cep, rua, numero, bairro, telefone
        );
    }
//  Setters


    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return String.format("%04d %-15s %-15s %-12s",
                getId(),
                getNome(),
                getCpf(),
                "Cliente");
    }
}