package com.newBig.system;

import com.newBig.system.application.usecase.Verificar;
import com.newBig.system.presentation.view.MenuView;
import com.newBig.system.presentation.view.UsuariosView;

import java.util.Scanner;


public class Main {
    static boolean aux;
    public static void main(String[] args) {
        UsuariosView usuariosView = new UsuariosView();
        MenuView menuView = new MenuView();
        Verificar verificar = new Verificar();
        Scanner sc = new Scanner(System.in);
        Long id = 0L;
        boolean acesso = false;
        if(!aux){
            id = verificar.login();
            acesso = verificar.acesso(id, 2);
        }
        else{
            aux = true;
        }
        if(acesso){
            menuView.principal(id);
            switch (verificar.opcao()){
                case 1:
                    /*Usuario*/
                    usuariosView.print();
                    break;
                case 2:
                    /*Produtos*/
                    break;
                case 3:
                    /*Caixa*/
                    break;
                case 4:
                    /*trocar usuario*/
                    aux = false;
                    Main.main(null);
                    break;
                case 0:
                    /*Sair*/
                    break;
                default:
                    System.out.println("Escolha uma opcao valida!!");
                    Main.main(null);
                    break;
            }
        }
        else{
            System.out.println("Erro no login tente novamente. Precione Enter - Login status " + aux);
            sc.nextLine();
            Main.main(null);
        }
    }
}