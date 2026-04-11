package com.newBig.system.presentation.controller;

import com.newBig.system.application.usecase.AddItemToSale;
import jakarta.persistence.EntityManager;

import java.util.UUID;

public class AddItemController {

    private AddItemToSale usecase;

    public AddItemController(EntityManager em) {
        this.usecase = new AddItemToSale(em);
    }

    public void execute(Long saleId, UUID productId, int quantity) {
        usecase.execute(saleId, productId, quantity);
    }

    public void addItens(Long saleId, UUID productId, int quantity) {
        usecase.adicionarLogica(saleId, productId, quantity);
    }

}
