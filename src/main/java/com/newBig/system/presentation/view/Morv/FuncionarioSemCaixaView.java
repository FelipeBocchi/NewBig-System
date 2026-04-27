package com.newBig.system.presentation.view.Morv;

import com.newBig.system.Main;
import com.newBig.system.infrastructure.persistence.CustomizerFactory;
import com.newBig.system.infrastructure.persistence.FuncionarioSemCaixaJoin;
import jakarta.persistence.EntityManager;

import java.util.Scanner;

public class FuncionarioSemCaixaView {
    EntityManager em = CustomizerFactory.getEntityManager();
    Scanner sc = new Scanner(System.in);
    FuncionarioSemCaixaJoin funcionarioSemCaixaJoin = new FuncionarioSemCaixaJoin(em);

    public void print(){
        try{
            var lista = funcionarioSemCaixaJoin.join();
            if(lista.isEmpty()){
                System.out.println("Nunca foi aberto caixa!!!");
            }
            else{
                System.out.println("--Funcionarios que nunca abriram caixa--");
                for (int i = 0; i < lista.size(); i++){
                    System.out.println(lista.get(i).getId() + " - " + lista.get(i).getNome());
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