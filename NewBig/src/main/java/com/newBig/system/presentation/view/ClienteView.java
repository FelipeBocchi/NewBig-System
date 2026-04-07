package com.newBig.system.presentation.view;

import com.newBig.system.domain.repository.ClienteRepo;
import com.newBig.system.domain.repository.CustomizerFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceException;

import java.util.Scanner;

public class ClienteView {
    EntityManager em = CustomizerFactory.getEntityManager(); /*Pegar objeto que conecta com o banco*/
    ClienteRepo dados = new ClienteRepo(em);
    Scanner sc = new Scanner(System.in);


    public void print(){
        try{
            var lista = dados.BuscaCliente(); /*passa a lista para uma variavel*/
            System.out.println("------------------------------------------------------------------------------------------------------------");
            System.out.printf("%-4s %-15s %-15s %-10s %-15s %-8s %-15s %-15s\n", "ID", "Nome", "CPF", "CEP", "Rua", "Num", "Bairro", "Telefone");
            System.out.println("------------------------------------------------------------------------------------------------------------");
            for (int i = 0; i < lista.size(); i++) {
                System.out.printf("%-4d %-15s %-15s %-10s %-15s %-8d %-15s %-15s\n", lista.get(i).getId(), lista.get(i).getNome(), lista.get(i).getCpf(), lista.get(i).getCep(), lista.get(i).getRua(), lista.get(i).getNumero(), lista.get(i).getBairro(), lista.get(i).getTelefone());
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage()); /*Imprime o erro*/
        }
    }

    public void nome(){
        try{
            System.out.println("Nome: ");
            var lista = dados.BuscaPorNome(sc.nextLine());
            System.out.println("------------------------------------------------------------------------------------------------------------");
            System.out.printf("%-4s %-15s %-15s %-10s %-15s %-8s %-15s %-15s\n", "ID", "Nome", "CPF", "CEP", "Rua", "Num", "Bairro", "Telefone");
            System.out.println("------------------------------------------------------------------------------------------------------------");
            for (int i = 0; i < lista.size(); i++) {
                System.out.printf("%-4d %-15s %-15s %-10s %-15s %-8d %-15s %-15s\n", lista.get(i).getId(), lista.get(i).getNome(), lista.get(i).getCpf(), lista.get(i).getCep(), lista.get(i).getRua(), lista.get(i).getNumero(), lista.get(i).getBairro(), lista.get(i).getTelefone());
            }
        }
        catch (PersistenceException e){
            System.out.println("Cliente não encontrado!!!");
        }
    }
}
