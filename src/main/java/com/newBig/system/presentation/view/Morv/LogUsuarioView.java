package com.newBig.system.presentation.view.Morv;

import com.newBig.system.Main;
import com.newBig.system.infrastructure.persistence.CustomizerFactory;
import com.newBig.system.infrastructure.persistence.LogUsuarioRepo;
import jakarta.persistence.EntityManager;

import java.util.Scanner;

public class LogUsuarioView {
    EntityManager em = CustomizerFactory.getEntityManager(); /*Pegar objeto que conecta com o banco*/
    LogUsuarioRepo logUsuarioRepo = new LogUsuarioRepo(em);
    Scanner sc = new Scanner(System.in);

    public void print(){
        var lista = logUsuarioRepo.listasLog();
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i).getId() + " - " + lista.get(i).getDescricao() + " - " + lista.get(i).getData());
        }
        System.out.println("--Enter para sair--");
        sc.nextLine();
        Main.main(null);
    };
}