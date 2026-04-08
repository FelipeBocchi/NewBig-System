package com.newBig.system;

import com.newBig.system.application.usecase.BuscarUsuarioVenda;
import com.newBig.system.application.usecase.Verificar;
import com.newBig.system.config.FlyWayConfig;
import com.newBig.system.presentation.view.CaixaView;
import com.newBig.system.presentation.view.MenuView;
import com.newBig.system.presentation.view.UsuariosView;

import java.util.Scanner;


public class Main {
    static boolean aux;
    static Long id = 0L;
    public static void main(String[] args) {
        UsuariosView usuariosView = new UsuariosView();
        MenuView menuView = new MenuView();
        Verificar verificar = new Verificar();
        CaixaView caixaView = new CaixaView();
        Scanner sc = new Scanner(System.in);
        BuscarUsuarioVenda buscarUsuarioVenda = new BuscarUsuarioVenda();
        FlyWayConfig.migrate();
        if(!aux){
            System.out.println("\n===============================");
            System.out.println("  🍦 NEW BIG SORVETERIA SYSTEM");
            System.out.println("===============================");
            id = verificar.login();
            aux = verificar.acesso(id, 2);
        }
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
                    caixaView.iniciar();
                    break;
                case 4:
                    /*trocar usuario*/
                    aux = false;
                    main(null);
                    break;
                case 5:
                    /*Vendas*/
                    buscarUsuarioVenda.cliente();
                    buscarUsuarioVenda.funcionario();
                    break;
                case 0:
                    /*Sair*/
                    break;
                default:
                    System.out.println("Escolha uma opcao valida!!");
                    main(null);
                    break;
            }
        }

}