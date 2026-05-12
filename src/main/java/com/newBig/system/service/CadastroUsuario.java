package com.newBig.system.service;

import com.newBig.system.Main;
import com.newBig.system.model.Cliente;
import com.newBig.system.model.Funcionario;
import com.newBig.system.repository.ClienteRepo;
import com.newBig.system.repository.CustomizerFactory;
import com.newBig.system.repository.FuncionarioRepo;
import jakarta.persistence.EntityManager;

import java.util.Scanner;

public class CadastroUsuario {
    Scanner sc = new Scanner(System.in);
    EntityManager em = CustomizerFactory.getEntityManager();
    FuncionarioRepo funRepo = new FuncionarioRepo(em);
    ClienteRepo cliRepo = new ClienteRepo(em);

    public void novoCliente(String nome, String cpf, String cep, String rua, int numero, String bairro, String telefone){
        Cliente dados = new Cliente(nome,cpf,cep,rua,numero, bairro, telefone);
        cliRepo.create(dados);
    }

    public void novoFuncionario(String nome, String cpf, int acesso, String login, int senha){
        Funcionario dados = new Funcionario(nome, cpf,acesso,login,senha);
        funRepo.create(dados);
    }


    public Long ultimoId(){
        return cliRepo.ultimoId();
    }

    public Long ultimoIdFun(){
        return funRepo.ultimoId();
    }

    public void limparBuffer(){sc.nextLine();}
}