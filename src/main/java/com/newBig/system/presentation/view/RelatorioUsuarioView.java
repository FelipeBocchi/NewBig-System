package com.newBig.system.presentation.view;

import com.newBig.system.Main;
import com.newBig.system.application.usecase.Verificar;

import java.util.Scanner;

public class RelatorioUsuarioView {
    Verificar verificar = new Verificar();
    ClienteView clienteView = new ClienteView();
    FuncionarioView funcionarioView = new FuncionarioView();
    Scanner sc = new Scanner(System.in);

    public void iniciar(){
        System.out.println("\n===============================");
        System.out.println("  🍦 NEW BIG SORVETERIA SYSTEM ");
        System.out.println("===============================");
        System.out.println("     Relatorios De Usuarios    ");
        System.out.println("===============================");
        System.out.println("1 - Cliente");
        System.out.println("2 - Funcionarios");
        System.out.println("0 - Voltar");
        System.out.println("===============================");
        switch (verificar.opcao()){
            case 1:
                clienteView.print();
                clienteView.nome();
                System.out.println("Enter para voltar: ");
                sc.nextLine();
                iniciar();
                break;
            case 2:
                funcionarioView.print();
                funcionarioView.nome();
                System.out.println("Enter para voltar: ");
                sc.nextLine();
                iniciar();
                break;
            case 0:
                Main.main(null);
                break;
            default:
                System.out.println("Erro tente novamente");
                iniciar();
                break;
        }
    }
}
