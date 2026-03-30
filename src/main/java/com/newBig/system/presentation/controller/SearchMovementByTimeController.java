package com.newBig.system.presentation.controller;

import com.newBig.system.application.usecase.SearchMovementByTime;
import com.newBig.system.domain.model.StockMovement;
import com.newBig.system.domain.repository.StockMovementRepository;
import com.newBig.system.presentation.view.AskDate;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

public class SearchMovementByTimeController {

    private SearchMovementByTime searchMovementByTime;
    private AskDate view = new AskDate();

    public SearchMovementByTimeController(StockMovementRepository repository) {
        this.searchMovementByTime = new SearchMovementByTime(repository);
    }

    public void execute() {
        //  = Tratamos o erro aqui, o erro é lançado através UseCase e capiturado no Controller
        while(true) {

            try {
                LocalDate day = view.askDate();
                List<StockMovement> result = searchMovementByTime.execute(day);

                view.showMovement(result);
                break;
            } catch (DateTimeParseException e) {
                view.showError("Formato inválido! Use YYYY-MM-DD");
            } catch (IllegalArgumentException e) {
                view.showError(e.getMessage());
            } catch (Exception e){
                view.showError("Erro inesperado.");
                e.printStackTrace();
            }
        }
    }
}
