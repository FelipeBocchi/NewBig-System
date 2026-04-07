package com.newBig.system.presentation.view;

import com.newBig.system.domain.repository.CustomizerFactory;
import com.newBig.system.domain.repository.FuncionarioRepo;
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
            System.out.println("Nome: ");
            var lista = dados.BuscaPorNome(sc.nextLine());
            System.out.println("-------------------------------------------------------------------");
            System.out.printf("%-4s %-15s %-15s %-12s\n", "ID", "Nome", "CPF", "Acesso");
            System.out.println("-------------------------------------------------------------------");
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
            System.out.println("Cliente não encontrado!!!");
        }
    }
}
