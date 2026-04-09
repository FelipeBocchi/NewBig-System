package com.newBig.system.presentation.controller;

import com.newBig.system.application.usecase.RegisterArrivalBatch;
import com.newBig.system.domain.repository.ProductRepository;

import java.time.LocalDate;
import java.util.UUID;

public class RegisterArrivalController {

    private RegisterArrivalBatch usecase;

    public RegisterArrivalController(RegisterArrivalBatch usecase) {
        this.usecase = usecase;
    }

    public void register(UUID idProduct, LocalDate validity, int amount, char series, ProductRepository repository) {
        usecase.execute(idProduct, validity, amount, series, repository);
    }
}
