package com.newBig.system;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or

import com.newBig.system.application.usecase.OperacaoCaixa;
import com.newBig.system.application.usecase.Pagamentos;
import com.newBig.system.application.usecase.RegisterProductUseCase;
import com.newBig.system.domain.model.Funcionario;
import com.newBig.system.domain.repository.ProductRepository;
import com.newBig.system.domain.service.ProductService;
import com.newBig.system.infrastructure.persistence.DadosUsuario;
import com.newBig.system.infrastructure.persistence.ProductMemoryRepository;
import com.newBig.system.presentation.controller.ProductController;
import com.newBig.system.presentation.view.*;

// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    static boolean rodou = false; /*Gerar o Admin sempre na primeira vez, e fazer login*/

    public static void main(String[] args) {
        ExibirMenus menu = new ExibirMenus();
        OperacaoCaixa caixa = new OperacaoCaixa();
        IniciarUsuario iniciarUsuario = new IniciarUsuario();
        LoginUsuario login = new LoginUsuario();
        Pagamentos pagar = new Pagamentos(); /*testando se vai funcionar, tirar antes da entrega*/

        if(!rodou){/*Gerar o Admin sempre na primeira vez, e fazer login*/
            DadosUsuario.usuario.add(new Funcionario("Admin", "000000000000", 1, "100", 1000)); /*Admin para ter um usuario para fazer o login*/
            login.login();
            rodou = true; /*Nao rodar mais*/
        }

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

            case 3:
                caixa.menuCaixa();
                break;
            case 4:
                login.login();
                main(null);
                break;
            case 5:
                pagar.pagamento(10);
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

