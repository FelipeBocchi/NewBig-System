package com.newBig.system.presentation.controller;

import com.newBig.system.application.usecase.BuyOfBatch;

import java.util.UUID;

public class BuyController {

    private BuyOfBatch useCase;

    public BuyController(BuyOfBatch useCase) {
        this.useCase = useCase;
    }

    public void buy(UUID idProduct, int quantity) {
        useCase.execute(idProduct, quantity);
    }

}
