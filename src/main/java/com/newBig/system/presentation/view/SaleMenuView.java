package com.newBig.system.presentation.view;

import com.newBig.system.application.usecase.Pagamentos;
import com.newBig.system.presentation.controller.AddItemController;
import com.newBig.system.presentation.controller.OpenSaleController;

import java.util.Scanner;

public class SaleMenuView {

    private Scanner sc = new Scanner(System.in);
    private ExibirMenus menu = new ExibirMenus();
    private SaleView saleView = new SaleView();
    private Pagamentos pagamentos = new Pagamentos();

    public void execute(OpenSaleController openSaleController, AddItemController addItemController) {

        int op;

        do {

            menu.saleMenu();
            op = sc.nextInt();
            sc.nextLine();

            switch (op) {

                case 1:
                    saleView.execute(openSaleController, addItemController);
                    pagamentos.pagamento(180);
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

