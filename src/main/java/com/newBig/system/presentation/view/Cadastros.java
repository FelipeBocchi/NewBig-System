package com.newBig.system.presentation.view;

import com.newBig.system.application.usecase.RegisterArrivalBatch;
import com.newBig.system.application.usecase.RegisterProductUseCase;
import com.newBig.system.domain.repository.ProductRepository;
import com.newBig.system.domain.repository.StockMovementRepository;
import com.newBig.system.domain.repository.StockRepository;
import com.newBig.system.presentation.controller.ProductController;
import com.newBig.system.presentation.controller.RegisterArrivalController;

import java.util.Scanner;

public class Cadastros {

    private ExibirMenus menu = new ExibirMenus();
    private Scanner sc = new Scanner(System.in);

    public void execute(ProductRepository repository, StockRepository stockRepository, StockMovementRepository stockMovementRepository) {

        int op;

        do {

            menu.cadastro();
            op = sc.nextInt();
            sc.nextLine();

            switch (op) {

                case 1:
                    IniciarUsuario iniciarUsuario = new IniciarUsuario();
                    iniciarUsuario.iniciar();
                    break;

                case 2:
                     // jogar para fora pq só cria uma vez

                    RegisterProductUseCase useCase = new RegisterProductUseCase(repository);

                    ProductController controller = new ProductController(useCase);

                    ProductView view = new ProductView(controller);

                    view.start();
                    break;

                case 3:


                    RegisterArrivalBatch registerArrivalBatch =  new RegisterArrivalBatch(stockRepository, stockMovementRepository);

                    RegisterArrivalController registerArrivalController = new RegisterArrivalController(registerArrivalBatch);

                    RegisterArrivalBatchView registerArrivalBatchView = new RegisterArrivalBatchView(registerArrivalController, repository, stockRepository, stockMovementRepository);

                    registerArrivalBatchView.start();

                    break;

                case 0:
                    System.out.println("\nEncerrando cadastros...");
                    break;

                default:
                    System.out.println("\nOpção inválida!");
            }

        } while (op != 0 );

    }
}
