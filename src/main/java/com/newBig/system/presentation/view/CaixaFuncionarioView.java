package com.newBig.system.presentation.view;

import com.newBig.system.Main;
import com.newBig.system.domain.repository.CustomizerFactory;
import com.newBig.system.domain.repository.FuncionarioCaixaJoin;
import jakarta.persistence.EntityManager;

import java.util.Scanner;

public class CaixaFuncionarioView {
    EntityManager em = CustomizerFactory.getEntityManager();
    Scanner sc = new Scanner(System.in);

    FuncionarioCaixaJoin funcionarioCaixaJoin = new FuncionarioCaixaJoin(em);
    public void print(){
        try{
            var lista = funcionarioCaixaJoin.join();
            if(lista.isEmpty()){
                System.out.println("Nunca foi aberto caixa!!!");
            }
            else{
                System.out.println("--Funcionario que abriu Caixa--");
                for (int i = 0; i < lista.size(); i++){
                    System.out.println("Funcionario: " + lista.get(i).getUsuarioAbertura().getNome());
                    System.out.println("Caixa que abriu id: " + lista.get(i).getId());
                    System.out.println("----------------------------------------------------------------");
                }
            }
            System.out.println("--Enter para voltar--");
            sc.nextLine();
            Main.main(null);
        }
        catch (Exception e){
            System.out.println("Erro: " + e.getMessage());
            Main.main(null);
        }
    }
}
