package com.newBig.system.presentation.view.Morv;

import com.newBig.system.Main;
import com.newBig.system.infrastructure.persistence.CustomizerFactory;
import com.newBig.system.infrastructure.persistence.FuncionarioRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceException;

import java.util.Scanner;

public class FuncionarioView {
    Scanner sc = new Scanner(System.in);
    EntityManager em = CustomizerFactory.getEntityManager(); /*Pegar objeto que conecta com o banco*/
    FuncionarioRepo dados = new FuncionarioRepo(em);

    public void print(){
        var lista = dados.BuscaFuncionarios(); /*passa a lista para uma variavel*/
        System.out.println("-------------------------------------------------------------------");
        System.out.printf("%-4s %-15s %-15s %-12s\n", "ID", "Nome", "CPF", "Acesso");
        System.out.println("-------------------------------------------------------------------");
        try{
            for (int i = 0; i < lista.size() ; i++) {
                if(lista.get(i).getAcesso() == 1){ /*Verificar se é administrador*/
                    System.out.printf("%-4s %-15s %-15s %-12s\n", lista.get(i).getId(), lista.get(i).getNome(), lista.get(i).getCpf(), "Administrador");
                } else if (lista.get(i).getAcesso() == 2) { /*Verificar se é operador*/
                    System.out.printf("%-4s %-15s %-15s %-12s\n", lista.get(i).getId(), lista.get(i).getNome(), lista.get(i).getCpf(), "Operador");
                }
                else{ /*Se não é nada é sem acesso*/
                    System.out.printf("%-4s %-15s %-15s %-12s\n", lista.get(i).getId(), lista.get(i).getNome(), lista.get(i).getCpf(), "Negado");

                }

            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage()); /*Imprime o erro*/
        }
    }

    public void nome(){
        try{
            System.out.println("Nome (Enter para sair): ");
            String nome = sc.nextLine();
            if(nome.isEmpty()){
                Main.main(null);
            }
            var lista = dados.BuscaPorNome(nome);
            System.out.println("-------------------------------------------------------------------");
            System.out.printf("%-4s %-15s %-15s %-12s\n", "ID", "Nome", "CPF", "Acesso");
            System.out.println("-------------------------------------------------------------------");
            if(lista.isEmpty()) { /*lista vazia*/
                System.out.println("Nenhum funcionario encontrado!!");
            }
            for (int i = 0; i < lista.size(); i++) {
                if(lista.get(i).getAcesso() == 1){ /*Verificar se é administrador*/
                    System.out.printf("%-4s %-15s %-15s %-12s\n", lista.get(i).getId(), lista.get(i).getNome(), lista.get(i).getCpf(), "Administrador");
                } else if (lista.get(i).getAcesso() == 2) { /*Verificar se é operador*/
                    System.out.printf("%-4s %-15s %-15s %-12s\n", lista.get(i).getId(), lista.get(i).getNome(), lista.get(i).getCpf(), "Operador");
                }
                else{ /*Se não é nada é sem acesso*/
                    System.out.printf("%-4s %-15s %-15s %-12s\n", lista.get(i).getId(), lista.get(i).getNome(), lista.get(i).getCpf(), "Negado");

                }
            }
        }
        catch (PersistenceException e){
            System.out.println("Erro ao consultar o banco!!!");
        }
    }


}