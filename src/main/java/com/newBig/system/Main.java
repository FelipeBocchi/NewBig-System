package com.newBig.system;

import com.newBig.system.application.usecase.RegisterProductUseCase;
import com.newBig.system.domain.repository.ProductRepository;
import com.newBig.system.domain.service.ProductService;
import com.newBig.system.infrastructure.persistence.ProductMemoryRepository;
import com.newBig.system.presentation.controller.ProductController;
import com.newBig.system.presentation.view.ProductView;

// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
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
                ProductRepository repository = new ProductMemoryRepository();

                //
                ProductService service = new ProductService(repository);

                //useCase
                RegisterProductUseCase useCase = new RegisterProductUseCase(service);

                ProductController controller = new ProductController(useCase);

                ProductView view = new ProductView(controller);

                view.start();
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

