package com.newBig.system.application.usecase;

import com.newBig.system.domain.model.StockMovement;
import com.newBig.system.domain.repository.StockMovementRepository;

import java.time.LocalDate;
import java.util.List;

public class SearchMovementByTime {

    private StockMovementRepository repository;

    public SearchMovementByTime(StockMovementRepository stockMovementRepository) {
        System.out.println("Repository: " + stockMovementRepository);
        this.repository = stockMovementRepository;
    }

    public List<StockMovement> execute(LocalDate day) {

        //  = A data pesquisada não pode ser futura, pois as movimentações são lançadas no momento de criação
        if (day.isAfter(LocalDate.now()))
            throw new IllegalArgumentException("A data não pode ser no futuro! ");

        return repository.searchByTime(day);

    }
}
