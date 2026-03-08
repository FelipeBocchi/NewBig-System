package com.newBig.system;
import com.newBig.system.applicaation.usercase.Utilidades;
import com.newBig.system.presentation.view.IniciarUsuario;
import com.newBig.system.presentation.view.ExibirMenus;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        ExibirMenus menu = new ExibirMenus();
        menu.principal();
        int op;
        while(true){
            if(sc.hasNextInt()){
                op = sc.nextInt();
                break;
            }
            else{
                System.out.println("Digite algo valido!!!");
                sc.nextLine();
            }
        }
        sc.nextLine();
        switch (op){
            case 1:
                IniciarUsuario iniciarUsuario = new IniciarUsuario();
                iniciarUsuario.iniciar();
                break;
            case 2:
                /*Parte dos produtos*/
                break;
            case 0:
                /*Sair*/
                break;
            default:
                System.out.println("Escolha uma opcao valida!!");
                main(null);
        }


    }
}