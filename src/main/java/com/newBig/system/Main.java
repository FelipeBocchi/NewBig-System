package com.newBig.system;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or

import com.newBig.system.domain.repository.ProductRepository;
import com.newBig.system.domain.repository.StockMovementRepository;
import com.newBig.system.domain.repository.StockRepository;
import com.newBig.system.infrastructure.persistence.MovementMemoryRepository;
import com.newBig.system.infrastructure.persistence.ProductMemoryRepository;
import com.newBig.system.infrastructure.persistence.StockMemoryRepository;
import com.newBig.system.presentation.view.Cadastros;

import com.newBig.system.presentation.view.ExibirMenus;

import java.util.Scanner;


public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        ProductRepository repository = new ProductMemoryRepository();
        StockRepository stockRepository = new StockMemoryRepository();
        StockMovementRepository stockMovementRepository = new MovementMemoryRepository();
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
                cadastros.execute(repository, stockRepository, stockMovementRepository);
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

