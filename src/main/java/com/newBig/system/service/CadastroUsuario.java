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
    Verificar verificar = new Verificar();

    public void novoCliente(String nome, String cpf, String cep, String rua, int numero, String bairro, String telefone){
        Cliente dados = new Cliente(nome,cpf,cep,rua,numero, bairro, telefone);
        cliRepo.create(dados);
    }

    public Long ultimoId(){
        return cliRepo.ultimoId();
    }

    public void limparBuffer(){sc.nextLine();}
}