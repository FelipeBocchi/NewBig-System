package com.newBig.system.presentation.view;

import com.newBig.system.application.usecase.RegisterArrivalBatch;
import com.newBig.system.domain.model.Batch;
import com.newBig.system.domain.model.Product;
import com.newBig.system.domain.model.StockMovement;
import com.newBig.system.domain.repository.ProductRepository;
import com.newBig.system.domain.repository.StockMovementRepository;
import com.newBig.system.domain.repository.StockRepository;
import com.newBig.system.infrastructure.persistence.ProductMemoryRepository;
import com.newBig.system.presentation.controller.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class RegisterArrivalBatchView {

    private ProductRepository repository;
    private StockRepository stockRepository;
    private StockMovementRepository stockMovementRepository;
    private Scanner sc = new Scanner(System.in);

    private RegisterArrivalController controller;
    private ListAllBatchController listAllBatchController = new ListAllBatchController();
    private ListAllMovementController listAllMovementController = new ListAllMovementController();
    private FindBatchExpiredController findBatchExpiredController;
    private DeleteExpiredBatchController deleteExpiredBatchController;
    private FilterBatchByStockController filterBatchByStockController;
    private SearchMovementByTimeController searchMovementByTimeController;

    public RegisterArrivalBatchView(RegisterArrivalController controller, ProductRepository repository, StockRepository stockRepository, StockMovementRepository stockMovementRepository) {
        this.controller = controller;
        this.repository = repository;
        this.stockRepository = stockRepository;
        this.stockMovementRepository = stockMovementRepository;
        this.findBatchExpiredController = new FindBatchExpiredController(stockRepository);
        this.deleteExpiredBatchController = new DeleteExpiredBatchController(stockRepository);
        this.filterBatchByStockController = new FilterBatchByStockController(stockRepository, repository);
        this.searchMovementByTimeController = new SearchMovementByTimeController(stockMovementRepository);
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
                    listAllBatch();
                    break;

                case 3:
                    listAllMovement();
                    break;

                case 4:
                    findExpiredBatch();
                    break;

                case 5:
                    filterBatchByStock();
                    break;

                case 6:
                    searchMovementByTime();
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
        System.out.println("2 - Listar Lotes no estoque");
        System.out.println("3 - Listar Movimentação de estoque");
        System.out.println("4 - Lotes vencidos");
        System.out.println("5 - Lotes com Estoque baixo");
        System.out.println("6 - Pesquisar movimentação por dia");
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

    public void listAllBatch() {
        System.out.println("\n===============================");
        System.out.println("\n=== LISTA DE LOTE ===");
        System.out.println("\n===============================");

        int i = 1;
        for(Batch b : listAllBatchController.execute(stockRepository)) {
        System.out.println("\n " + i + "= " + b.getSeries() + " | " + b.getProduct().getId() + " | " + b.getAmount() + " | " + b.getValidity());
        i++;
        }
        System.out.println("\n===============================");
    }

    public void listAllMovement() {
        System.out.println("\n===============================");
        System.out.println("\n=== LISTA DE MOVIMENTAÇÕES ===");
        System.out.println("\n===============================");

        int i = 1;
        for(StockMovement s : listAllMovementController.execute(stockMovementRepository)) {
            System.out.println("\n " + i + "= " + s.getIdBatch() + " | " + s.getType() + " | " + s.getDate() + " | " + s.getQuantity() + " | " + s.getValue());
            i++;
        }
        System.out.println("\n===============================");
    }

    public void findExpiredBatch() {
        System.out.println("\n===============================");
        System.out.println("\n=== LOTES VENCIDOS ===");
        System.out.println("\n===============================");

        System.out.println("\n\n===============================");
        int i = 1;
        for(Batch b : findBatchExpiredController.execute()) {
            System.out.println("\n " + i + "= " + b.getSeries() + " | " + b.getId() + " | " + b.getValidity() + " | " + b.getAmount() + " | " + b.getProduct().getSalePrice().multiply(BigDecimal.valueOf(b.getAmount())));
            i++;
        }
        System.out.println("\n===============================");

        char op;
        do {
            System.out.println("\n\n= Deseja deletar os lotes vencidos(Y/N): ");
            op = sc.next().charAt(0);

            if (Character.toUpperCase(op) == 'Y') {
                deleteExpiredBatchController.execute();
            } else if(Character.toUpperCase(op) != 'N' && Character.toUpperCase(op) != 'Y')
                System.out.println(" OPÇÃO INVALIDA!!!");

        }while (Character.toUpperCase(op) != 'N' && Character.toUpperCase(op) != 'Y');

        System.out.println("\n\n===============================");
    }

    public void filterBatchByStock() {
        System.out.println("\n===============================");
        System.out.println("\n===  LOTES COM ESTOQUE BAIXO ===");
        System.out.println("\n===============================");

        int i = 1;
        for(Batch b : filterBatchByStockController.execute()) {
            System.out.println("\n " + i + "= " + b.getSeries() + " | " + b.getId() + " | " + b.getValidity() + " | " + b.getAmount() + " | " + b.getProduct().getSalePrice().multiply(BigDecimal.valueOf(b.getAmount())));
            i++;
        }
        System.out.println("\n===============================");
    }

    public void searchMovementByTime() {
        System.out.println("\n===============================");
        System.out.println("\n===  MOVIMENTAÇÃO NESSE DIA ===");
        System.out.println("\n===============================");

        searchMovementByTimeController.execute();
        System.out.println("\n===============================");
    }
}
