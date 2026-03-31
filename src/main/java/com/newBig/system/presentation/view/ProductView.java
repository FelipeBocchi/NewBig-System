package com.newBig.system.presentation.view;

import com.newBig.system.domain.model.Product;
import com.newBig.system.presentation.controller.ProductController;

import java.math.BigDecimal;
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

                case 3:
                    listFindCategory();
                    break;

                case 4:
                    listFindType();
                    break;


                case 6:
                    listFindPrice();
                    break;

                case 7:
                    listFindUnit();
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
        System.out.println("3 - Filtar por Categoria");
        System.out.println("4 - Filtar por Type");
        System.out.println("6 - Filtar por Preço");
        System.out.println("7 - Filtar por Unit");
        System.out.println("0 - Sair");
        System.out.println("===============================");
        System.out.print("Escolha uma opção: ");
    }

    private void registerProduct() {

        System.out.println("\n=== Cadastro de Produto ===");

        System.out.print("Produto: ");
        String productName = sc.nextLine();

        System.out.print("Descrição: ");
        String description = sc.nextLine();

        System.out.print("Departamento: ");
        String department = sc.nextLine();

        System.out.print("Categoria: ");
        String category = sc.nextLine();

        System.out.print("Código de Barras: ");
        int barcode = sc.nextInt();

        System.out.print("Preço de custo: ");
        BigDecimal costPrice = sc.nextBigDecimal();

        System.out.print("Preço de venda: ");
        BigDecimal salePrice = sc.nextBigDecimal();

        System.out.print("Estoque minimo: ");
        int minimumStock = sc.nextInt();

        sc.nextLine();

        System.out.println("Tipos disponíveis:");
        for(Product.ProductType t : Product.ProductType.values()){
            System.out.println("- " + t);
        }
        String input = sc.nextLine();
        Product.ProductType type = Product.ProductType.valueOf(input.toUpperCase());

        System.out.println("Tipos disponíveis:");
        for(Product.UnitType t : Product.UnitType.values()){
            System.out.println("- " + t);
        }
        input = sc.nextLine();
        Product.UnitType unit = Product.UnitType.valueOf(input.toUpperCase());

        controller.register(productName, description, department, category, barcode, costPrice, salePrice, minimumStock, type, unit);

        System.out.println("\n✅ Produto cadastrado com sucesso!");
    }

    private void listProducts() {

        System.out.println("\n=== Produtos Cadastrados ===");

        controller.list().forEach(p ->
                System.out.println(
                        p.getDepartment() + " | " +
                                p.getCategory() + " | " +
                                p.getProductName() + " | " +
                                p.getBarcode() + " [ " +
                                p.getId()

                )
        );
    }

    private void listFindCategory() {
        System.out.println(" == Qual categoria quer achar: ");
        String category = sc.nextLine();

        System.out.println("\n=== Categoria de Produtos ===");

        controller.listFindByCategory(category).forEach(p ->
                System.out.println(
                        p.getProductName() + " | " + p.calculateMargin()
                )
        );
    }

    private void listFindType() {
        System.out.println(" == Qual tipo de produto quer achar: ");
        for(Product.ProductType t : Product.ProductType.values()){
            System.out.println("- " + t);
        }

        String type = sc.nextLine();
        Product.ProductType typeP = Product.ProductType.valueOf(type.toUpperCase());

        System.out.println("\n=== Tipo " + type + " ===");

        controller.listFindByType(typeP).forEach(p ->
                System.out.println(
                        p.getProductName()
                )
        );
    }


    private void listFindPrice() {
        System.out.println(" == Qual parametro de preço quer achar: ");
        System.out.println(" == :1: valor de custo ");
        System.out.println(" == :2: valor de venda ");
        System.out.println(" == :3: valor de venda especifico");
        int op = sc.nextInt();

        switch (op){
            case 1:
                System.out.println("\n=== Até qual valor de custo quer filtar: ");
                BigDecimal price = sc.nextBigDecimal();

                controller.listFindByCostPrice(price).forEach( p ->
                        System.out.println(
                                p.getProductName()
                        ));
                break;

            case 2:
                System.out.println("\n=== Até qual valor de venda quer filtar: ");
                price = sc.nextBigDecimal();

                controller.listFindBySalePrice(price).forEach( p ->
                        System.out.println(
                                p.getProductName()
                        ));
                break;

            case 3:
                System.out.println("\n=== Até qual valor especifico quer filtar: ");
                price = sc.nextBigDecimal();

                controller.listFindByEqualPrice(price).forEach( p ->
                        System.out.println(
                                p.getProductName()
                        ));
                break;

            default:
                System.out.println(" === opção invalida!!! ");

        }

    }

    private void listFindUnit() {
        System.out.println(" == Qual tipo de unidade de produto quer achar: ");
        for(Product.UnitType t : Product.UnitType.values()){
            System.out.println("- " + t);
        }

        String unit = sc.nextLine();
        Product.UnitType unitP = Product.UnitType.valueOf(unit.toUpperCase());

        System.out.println("\n=== Tipo " + unit + " ===");

        controller.listFindByUnit(unitP).forEach(p ->
                System.out.println(
                        p.getProductName()
                )
        );
    }

}