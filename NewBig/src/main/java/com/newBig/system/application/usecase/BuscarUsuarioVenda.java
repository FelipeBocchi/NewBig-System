package com.newBig.system.application.usecase;

import com.newBig.system.domain.model.Cliente;
import com.newBig.system.domain.model.Funcionario;
import com.newBig.system.domain.repository.ClienteRepo;
import com.newBig.system.domain.repository.CustomizerFactory;
import com.newBig.system.domain.repository.FuncionarioRepo;
import com.newBig.system.presentation.view.ClienteView;
import com.newBig.system.presentation.view.FuncionarioView;
import jakarta.persistence.EntityManager;

public class BuscarUsuarioVenda {
    EntityManager em = CustomizerFactory.getEntityManager(); /*Pegar objeto que conecta com o banco*/
    ClienteView clienteView = new ClienteView();
    Verificar verificar = new Verificar();
    ClienteRepo clienteRepo = new ClienteRepo(em);
    FuncionarioRepo funcionarioRepo = new FuncionarioRepo(em);
    FuncionarioView funcionarioView = new FuncionarioView();

    public Cliente cliente(){
        try {
            clienteView.print();
            Long id = verificar.id();
            return clienteRepo.SelecionarCliente(id);
        }
        catch (Exception e){
            System.out.println("Erro ao buscar cliente!!");
            /*Adiciona o que voce acha que deve acontecer caso der erro*/
            return null;
        }
    }

    public Funcionario funcionario(){
        try {
            funcionarioView.print();
            Long id = verificar.id();
            return funcionarioRepo.SelecionarFuncionario(id);
        }
        catch (Exception e){
            System.out.println("Erro ao buscar funcionarios!!");
            /*Adiciona o que voce acha que deve acontecer caso der erro*/
            return null;
        }
    }
}
