package com.newBig.system.presentation.view;

import com.newBig.system.application.usecase.BuscarUsuarioVenda;
import com.newBig.system.domain.model.Cliente;
import com.newBig.system.domain.model.Funcionario;
import com.newBig.system.domain.model.Sale;
import com.newBig.system.presentation.controller.AddItemController;
import com.newBig.system.presentation.controller.OpenSaleController;

import java.util.Scanner;
import java.util.UUID;

public class SaleView {

    BuscarUsuarioVenda buscarUsuarioVenda = new BuscarUsuarioVenda();

    UUID idProduct = null;
    private Scanner sc = new Scanner(System.in);
    private Cliente cliente;
    private Funcionario funcionario;
    private Sale sale = null;

    public void execute(OpenSaleController openSaleController, AddItemController addItemController) {

        System.out.println("\n===============================");
        System.out.println("  🍦 NEW BIG SORVETERIA SYSTEM");
        System.out.println("===============================");
        System.out.println("            VENDA           ");
        System.out.println("===============================\n\n");

        cliente = buscarUsuarioVenda.cliente();
        funcionario = buscarUsuarioVenda.funcionario();

        System.out.println(" - Insira o código do produto: ");
        String input = sc.nextLine();

        try {
            // Converte a string para UUID
            idProduct = UUID.fromString(input);
            System.out.println("UUID capturado com sucesso: " + idProduct.toString());
        } catch (IllegalArgumentException e) {
            // Trata o caso de a string não ser um UUID válido
            System.err.println("UUID inválido! O formato correto é: " +
                    "xxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxxx");
        }
        System.out.println("\n===============================");

        System.out.println(" - Insira a quantidade do produto: ");
        int quantity = sc.nextInt();
        System.out.println("\n===============================");

        Long idSaleCurrent = openSaleController.execute(cliente.getId(), funcionario.getId(), idProduct, quantity, "DINHEIRO");

        int op;
        while(true){
            op = 1;
            System.out.println(" - Há um proxímo produto? ( 0 = não | 1 = sim) ");
            op = sc.nextInt();
            if(op == 0) { break;}
            sc.nextLine();

            System.out.println(" - Insira o código do proxímo produto: ");
            input = sc.nextLine();

            try {
                // Converte a string para UUID
                idProduct = UUID.fromString(input);
                System.out.println("UUID capturado com sucesso: " + idProduct.toString());
            } catch (IllegalArgumentException e) {
                // Trata o caso de a string não ser um UUID válido
                System.err.println("UUID inválido! O formato correto é: " +
                        "xxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxxx");
            }
            System.out.println("\n===============================");

            System.out.println(" - Insira a quantidade desse produto: ");
            quantity = sc.nextInt();
            System.out.println("\n===============================");

            addItemController.execute(idSaleCurrent, idProduct, quantity);

        }

        // somatoria dos itens da compra

    }
}
