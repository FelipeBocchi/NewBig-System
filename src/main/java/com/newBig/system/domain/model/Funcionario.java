package com.newBig.system.domain.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "funcionario")
public class Funcionario{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "cpf", nullable = false, unique = true, length = 11)
    private String cpf;

    @Column(name = "acesso", nullable = false)
    private int acesso;

    @Column(name = "login", nullable = false, length = 100)
    private String login;

    @Column(name = "senha", nullable = false)
    private int senha;

    @OneToMany(mappedBy = "usuarioAbertura")
    private List<DadosCaixa> dadosCaixa;
    public Funcionario(){};

    public Funcionario(String nome, String cpf, int acesso, String login, int senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.acesso = acesso;
        this.login = login;
        this.senha = senha;
    }

    /*----------------------Geters------------------*/

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public int getAcesso() {
        return acesso;
    }

    public String getLogin() {
        return login;
    }

    public int getSenha() {
        return senha;
    }

    public String getDadosFuncionario(){
        return String.format("Login: %s  Senha: %d",
                getLogin(),
                getSenha());
    }


    /*--------------------setters-----------------------*/

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setAcesso(int acesso) {
        this.acesso = acesso;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }

    // Escrever o nivel do acesso do funcionario
    public String FuncionarioAcesso(){
        switch (this.acesso){
            case 1:
                return "Administrador";

            case 2:
                return "Operador";

            default:
                return "Sem acesso";

        }
    }

    //    to String


    @Override
    public String toString() {
        return String.format("%04d %-15s %-15s %-12s",
                getId(),
                getNome(),
                getCpf(),
                FuncionarioAcesso());
    }
}