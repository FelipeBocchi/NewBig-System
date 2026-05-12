package com.newBig.system.service;

import com.newBig.system.repository.ClienteRepo;
import com.newBig.system.repository.CustomizerFactory;
import com.newBig.system.repository.FuncionarioRepo;
import jakarta.persistence.EntityManager;

public class DeletarUsuario {

    public void deleteCliente(Long id){
        EntityManager em = CustomizerFactory.getEntityManager(); /*Pegar objeto que conecta com o banco*/
        ClienteRepo dados = new ClienteRepo(em);
        dados.delete(dados.SelecionarCliente(id));
    }

    public void deleteFuncionario(Long id){
        EntityManager em = CustomizerFactory.getEntityManager(); /*Pegar objeto que conecta com o banco*/
        FuncionarioRepo dados = new FuncionarioRepo(em);
        dados.delete(dados.SelecionarFuncionario(id));
    }

}
