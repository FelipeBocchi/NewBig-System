package com.newBig.system.service;

import com.newBig.system.Main;
import com.newBig.system.model.Cliente;
import com.newBig.system.model.Funcionario;
import com.newBig.system.repository.ClienteRepo;
import com.newBig.system.repository.CustomizerFactory;
import com.newBig.system.repository.FuncionarioRepo;
import com.newBig.system.presentation.view.ClienteView;
import com.newBig.system.presentation.view.FuncionarioView;
import jakarta.persistence.EntityManager;

import java.util.Scanner;

public class AtualizarUsuario {
    EntityManager em = CustomizerFactory.getEntityManager(); /*Pegar objeto que conecta com o banco*/
    FuncionarioRepo funcionarioRepo = new FuncionarioRepo(em);
    ClienteRepo clienteRepo = new ClienteRepo(em);


    public void funcionario(Long id, String nome, String cpf, String login, int senha, int acesso){
        var dados = funcionarioRepo.SelecionarFuncionario(id);
        dados.setNome(nome);
        dados.setCpf(cpf);
        dados.setLogin(login);
        dados.setSenha(senha);
        dados.setAcesso(acesso);
        funcionarioRepo.update(dados);

    }

    public void cliente(Long id, String nome, String cpf, String cep, String rua, int numero, String bairro, String telefone){
        var dados = clienteRepo.SelecionarCliente(id);
        dados.setNome(nome);
        dados.setCpf(cpf);
        dados.setCep(cep);
        dados.setRua(rua);
        dados.setNumero(numero);
        dados.setTelefone(telefone);
        dados.setBairro(bairro);
        clienteRepo.update(dados);
    }

    public Cliente dadosCliente(Long id){
        return clienteRepo.SelecionarCliente(id);
    }

    public Funcionario dadosFuncionario(Long id){return funcionarioRepo.SelecionarFuncionario(id);}
}