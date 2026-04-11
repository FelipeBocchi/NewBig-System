package com.newBig.system.presentation.controller;

import com.newBig.system.application.usecase.AddItemToSale;
import com.newBig.system.application.usecase.OpenSale;
import jakarta.persistence.EntityManager;

import java.util.UUID;

public class OpenSaleController {

    private OpenSale usecase;
    private AddItemToSale addItemToSale;

    public OpenSaleController(EntityManager em, AddItemToSale addItemToSale) {
        this.addItemToSale = addItemToSale;
        this.usecase = new OpenSale(em, addItemToSale);
    }

    public Long execute(Long clienteId, Long funcionarioId, UUID firstProductId, int quantity, String paymentMethod) {
        return usecase.execute(clienteId, funcionarioId, firstProductId, quantity, paymentMethod);

    }
}
