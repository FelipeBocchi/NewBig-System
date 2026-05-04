package com.newBig.system.service;

import com.newBig.system.model.Sale;
import com.newBig.system.repository.SaleInterface;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;


public class OpenSale {

    private SaleInterface repositorySale;
    private AddItemToSale addItemToSale;

    public OpenSale(SaleInterface repositorySale, AddItemToSale addItemToSale) {
        this.repositorySale = repositorySale;
        this.addItemToSale = addItemToSale;
    }

    public Long execute(Long clienteId, Long funcionarioId, Long firstProductId, int quantity, String paymentMethod) {


    }


}
