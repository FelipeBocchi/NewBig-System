package com.newBig.system.model.service.usuario.impl;

import com.newBig.system.model.entity.Cliente;
import com.newBig.system.model.entity.Funcionario;
import com.newBig.system.model.repository.ClienteRepo;
import com.newBig.system.model.repository.CustomizerFactory;
import com.newBig.system.model.repository.FuncionarioRepo;
import com.newBig.system.model.service.usuario.AtualizarUsuarioServiceItf;
import jakarta.persistence.EntityManager;

public class AtualizarUsuario implements AtualizarUsuarioServiceItf {
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