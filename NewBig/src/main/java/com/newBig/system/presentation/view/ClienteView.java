package com.newBig.system.presentation.view;

import com.newBig.system.domain.repository.ClienteRepo;
import com.newBig.system.domain.repository.CustomizerFactory;
import jakarta.persistence.EntityManager;

public class ClienteView {

    public void print(){
        EntityManager em = CustomizerFactory.getEntityManager(); /*Pegar objeto que conecta com o banco*/
        try{
            ClienteRepo dados = new ClienteRepo(em);
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
}
