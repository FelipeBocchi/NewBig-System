package com.newBig.system.service;

import com.newBig.system.domain.model.Cliente;
import com.newBig.system.domain.model.Funcionario;
import com.newBig.system.model.Sale;
import com.newBig.system.repository.SaleInterface;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;


public class OpenSale {

    private SaleInterface repositorySale;
    private AddItemToSale addItemToSale;
    // cliente
    // funcionario

    public OpenSale(SaleInterface repositorySale, AddItemToSale addItemToSale) {
        this.repositorySale = repositorySale;
        this.addItemToSale = addItemToSale;
    }

    public Long execute(Long clienteId, Long funcionarioId, Long firstProductId, int quantity, String paymentMethod) {

        // cliente
        Cliente cliente = new Cliente();
        // funcionario
        Funcionario func = new Funcionario();

        //  = Venda esqueleto que vai servir de ponto de início da venda
        // !!! validações
        Sale sale = new Sale(LocalDateTime.now(), cliente, func, BigDecimal.ZERO, paymentMethod, "ABERTA", new ArrayList<>());
        repositorySale.save(sale);

        addItemToSale.logic(sale.getId(), firstProductId, quantity);

        return sale.getId();
    }


}
