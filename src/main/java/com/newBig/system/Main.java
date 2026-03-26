package com.newBig.system;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or

import com.newBig.system.application.usecase.RegisterProductUseCase;
import com.newBig.system.domain.repository.ProductRepository;
import com.newBig.system.domain.repository.StockRepository;
import com.newBig.system.domain.service.ProductService;
import com.newBig.system.infrastructure.persistence.ProductMemoryRepository;
import com.newBig.system.infrastructure.persistence.StockMemoryRepository;
import com.newBig.system.presentation.controller.ProductController;
import com.newBig.system.presentation.view.Cadastros;
import com.newBig.system.presentation.view.ProductView;

// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import com.newBig.system.applicaation.usercase.Utilidades;
import com.newBig.system.presentation.view.IniciarUsuario;
import com.newBig.system.presentation.view.ExibirMenus;

import java.util.Scanner;

import static java.awt.SystemColor.menu;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        ProductRepository repository = new ProductMemoryRepository();
        StockRepository stockRepository = new StockMemoryRepository();
        Cadastros cadastros = new Cadastros();
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
                cadastros.execute(repository, stockRepository);
                break;
            case 2:

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

