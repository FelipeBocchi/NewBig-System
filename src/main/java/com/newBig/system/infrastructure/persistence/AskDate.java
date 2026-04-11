package com.newBig.system.infrastructure.persistence;

import com.newBig.system.domain.model.StockMovement;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class AskDate {

    public LocalDate askDate() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite a data (YYYY-MM-DD): ");
        String input = sc.nextLine().trim();

        return LocalDate.parse(input);
    }

    public void showMovement(List<StockMovement> result) {

        int i = 1;
        for (StockMovement s : result) {
            System.out.println("\n " + i + "= " + s.getIdBatch() + " | " + s.getType() + " | " + s.getDate() + " | " + s.getQuantity() + " | " + s.getValue());
            i++;
        }
    }

    public void showError(String message) {
        System.out.println("Erro: " + message);
    }
}
