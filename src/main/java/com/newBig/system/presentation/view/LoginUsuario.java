package com.newBig.system.presentation.view;

import com.newBig.system.application.usecase.Verificacoes;

import java.util.Scanner;


public class LoginUsuario {
    Verificacoes verificar = new Verificacoes();
    Scanner sc = new Scanner(System.in);
    public void login(){
        verificar.retIdLogado(); /*retira o dados do antigo usuario logado*/
        verificar.retNomeLogado(); /*retira o dados do antigo usuario logado*/
        System.out.println("\n===============================");
        System.out.println("  🍦 NEW BIG SORVETERIA SYSTEM");
        System.out.println("           --LOGIN--           ");
        System.out.println("===============================");
        System.out.println("Digite seu login: ");
        String login = sc.nextLine();
        int senha = verificar.senha();
        boolean passou =  verificar.login(login, senha); /*Retorna se ele passou*/
        if(!passou){
            System.out.println("Erro ao login tente novamente!!!");
            login();
        }

    };


}
