package com.newBig.system.presentation.view;

import com.newBig.system.presentation.controller.ProductController;

import java.util.Scanner;

public class ProductView {

    private ProductController controller;
    private Scanner sc = new Scanner(System.in);

    public ProductView(ProductController controller) {
        this.controller = controller;
    }

    public void start() {

        int option;

        do {
            showMenu();
            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    registerProduct();
                    break;

                case 2:
                    listProducts();
                    break;

                case 0:
                    System.out.println("\nEncerrando sistema...");
                    break;

                default:
                    System.out.println("\nOpção inválida!");
            }

        } while (option != 0);
    }

    private void showMenu() {

        System.out.println("\n===============================");
        System.out.println("  🍦 NEW BIG SORVETERIA SYSTEM");
        System.out.println("===============================");
        System.out.println("1 - Cadastrar Produto");
        System.out.println("2 - Listar Produtos");
        System.out.println("0 - Sair");
        System.out.println("===============================");
        System.out.print("Escolha uma opção: ");
    }

    private void registerProduct() {

        System.out.println("\n=== Cadastro de Produto ===");

        System.out.print("Departamento: ");
        String department = sc.nextLine();

        System.out.print("Categoria: ");
        String category = sc.nextLine();

        System.out.print("Produto: ");
        String productName = sc.nextLine();

        System.out.print("SKU: ");
        String sku = sc.nextLine();

        System.out.print("Código de Barras: ");
        int barCode = sc.nextInt();

        System.out.print("Preço: ");
        double price = sc.nextDouble();

        System.out.print("Estoque: ");
        int stock = sc.nextInt();
        sc.nextLine();

        controller.register(department, category, productName, sku, barCode, price, stock);

        System.out.println("\n✅ Produto cadastrado com sucesso!");
    }

    private void listProducts() {

        System.out.println("\n=== Produtos Cadastrados ===");

        controller.list().forEach(p ->
                System.out.println(
                        p.getDepartment() + " | " +
                                p.getCategory() + " | " +
                                p.getProductName() + " | " +
                                p.getSku() + " | " +
                                p.getBarcode() + " | R$ " +
                                p.getPrice()
                )
        );
    }
}