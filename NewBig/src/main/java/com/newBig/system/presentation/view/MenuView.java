package com.newBig.system.presentation.view;

import com.newBig.system.application.usecase.Verificar;

public class MenuView {
    Verificar verificar = new Verificar();

    public void principal(Long id){
        System.out.println("\n===============================");
        System.out.println("  🍦 NEW BIG SORVETERIA SYSTEM");
        System.out.println("===============================");
        System.out.println("1 - Usuarios");
        System.out.println("2 - Produtos");
        System.out.println("3 - Caixa");
        System.out.println("4 - Trocar Usuario");
        System.out.println("0 - Sair");
        System.out.println("===============================");
        System.out.println("Usuario Logado: " + id + " - " + verificar.nomeLogado(id));
        System.out.println("===============================");

        System.out.print("Escolha uma opção: ");

    }
}
