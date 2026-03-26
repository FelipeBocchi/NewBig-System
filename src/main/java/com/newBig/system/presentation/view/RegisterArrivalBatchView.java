package com.newBig.system.presentation.view;

import com.newBig.system.application.usecase.RegisterArrivalBatch;
import com.newBig.system.domain.model.Product;
import com.newBig.system.domain.repository.ProductRepository;
import com.newBig.system.infrastructure.persistence.ProductMemoryRepository;
import com.newBig.system.presentation.controller.RegisterArrivalController;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class RegisterArrivalBatchView {

    private ProductRepository repository;
    private RegisterArrivalController controller;
    private Scanner sc = new Scanner(System.in);

    public RegisterArrivalBatchView(RegisterArrivalController controller, ProductRepository repository) {
        this.controller = controller;
        this.repository = repository;
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

                case 0:
                    System.out.println("\nEncerrando sistema...");
                    break;

                default:
                    System.out.println("\nOpção inválida!");
            }

        } while (option != 0);
    }

    public void showMenu() {

        System.out.println("\n===============================");
        System.out.println("  🍦 NEW BIG SORVETERIA SYSTEM");
        System.out.println("===============================");
        System.out.println("1 - Cadastrar lote");
        System.out.println("0 - Sair");
        System.out.println("===============================");
        System.out.print("Escolha uma opção: ");
    }

    private void registerProduct() {

        UUID idProduct = null;
        LocalDate validity = null;

        System.out.println("\n===============================");
        System.out.println("\n=== CADASTRO DE LOTE ===");
        System.out.println("\n===============================");
        
        System.out.println(" = ID do produto: ");
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

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.print(" = Validade do Lote (dd/MM/yyyy): ");
        String dataInput = sc.nextLine();

        try {
            // Converte a string para LocalDate
            validity = LocalDate.parse(dataInput, formatter);
            System.out.println("Data capturada: " + validity);
            System.out.println("Data formatada: " + validity.format(formatter));
        } catch (Exception e) {
            System.out.println("Formato de data inválido! Use dd/MM/yyyy.");
        }
        System.out.println("\n===============================");

        System.out.println(" = Unidades de produto: ");
        int quantity = sc.nextInt();
        System.out.println("\n===============================");

        sc.nextLine();

        System.out.println(" = ID do produto: ");
        char serie = sc.next().charAt(0);
        System.out.println("\n===============================");

        // UUID idProduct, LocalDate validity, int amount, char series
        controller.register(idProduct, validity, quantity, serie, repository);

        System.out.println("\n✅ Lote cadastrado com sucesso!");
    }
}
