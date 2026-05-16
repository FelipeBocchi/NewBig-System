package com.newBig.system.service;

import com.newBig.system.repository.CustomizerFactory;
import com.newBig.system.repository.FuncionarioRepo;
import jakarta.persistence.EntityManager;

public class Login {
    EntityManager em = CustomizerFactory.getEntityManager(); /*Pegar objeto que conecta com o banco*/
    FuncionarioRepo funcionarioRepo = new FuncionarioRepo(em);
    static Long funLog = null;

    public Long verificar(String login, int senha){
        var funcionarios = funcionarioRepo.BuscaFuncionarios();
        for (int i = 0; i < funcionarios.size(); i++) {
            if (login.equals(funcionarios.get(i).getLogin()) && senha == funcionarios.get(i).getSenha()){
                return funcionarios.get(i).getId();
            }
        }
        return -1L;
    }

    public int acesso(Long id){
        var fun = funcionarioRepo.SelecionarFuncionario(id);
        return fun.getAcesso();
    }

    public void salvar(Long id){
        funLog = id;
    }

    public Long consultarFun(){
        return funLog;
    }

    public String nomeLog(){
        return funcionarioRepo.SelecionarFuncionario(funLog).getNome();
    }

    public String acessoLog(){
        if(funcionarioRepo.SelecionarFuncionario(funLog).getAcesso() == 1){
            return "Administrador";
        }else{
            return "Operador";
        }
    }

    public int acessoNivel(){
        return funcionarioRepo.SelecionarFuncionario(funLog).getAcesso();
    }

}
