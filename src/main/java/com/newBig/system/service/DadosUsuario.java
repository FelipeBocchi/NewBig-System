package com.newBig.system.service;

import com.newBig.system.model.Cliente;
import com.newBig.system.model.Funcionario;
import com.newBig.system.repository.ClienteRepo;
import com.newBig.system.repository.CustomizerFactory;
import com.newBig.system.repository.FuncionarioRepo;
import jakarta.persistence.EntityManager;

import java.util.List;

public class DadosUsuario {

    public List<Funcionario> dadosFuncionario(){
        EntityManager em = CustomizerFactory.getEntityManager(); /*Pegar objeto que conecta com o banco*/
        FuncionarioRepo dados = new FuncionarioRepo(em);
        return dados.BuscaFuncionarios();
    }

    public List<Funcionario> dadosFuncionarioNome(String nome){
        EntityManager em = CustomizerFactory.getEntityManager(); /*Pegar objeto que conecta com o banco*/
        FuncionarioRepo dados = new FuncionarioRepo(em);
        return dados.BuscaPorNome(nome);
    }

    public Funcionario dadosCompletosFuncionario(Long id){
        EntityManager em = CustomizerFactory.getEntityManager(); /*Pegar objeto que conecta com o banco*/
        FuncionarioRepo dados = new FuncionarioRepo(em);
        return dados.SelecionarFuncionario(id);
    }

    public List<Cliente> dadosCliente(){
        EntityManager em = CustomizerFactory.getEntityManager(); /*Pegar objeto que conecta com o banco*/
        ClienteRepo clienteRepo = new ClienteRepo(em);
        return clienteRepo.BuscaCliente();
    }

    public List<Cliente> dadosClienteNome(String nome){
        EntityManager em = CustomizerFactory.getEntityManager(); /*Pegar objeto que conecta com o banco*/
        ClienteRepo clienteRepo = new ClienteRepo(em);
        return clienteRepo.BuscaPorNome(nome);
    }

    public List<Cliente> dadosClienteCpf(String cpf){
        EntityManager em = CustomizerFactory.getEntityManager(); /*Pegar objeto que conecta com o banco*/
        ClienteRepo clienteRepo = new ClienteRepo(em);
        return clienteRepo.BuscaPorCPF(cpf);
    }


}
