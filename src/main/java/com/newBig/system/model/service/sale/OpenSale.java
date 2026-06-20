package com.newBig.system.model.service.sale;

import com.newBig.system.model.entity.Cliente;
import com.newBig.system.model.entity.Funcionario;
import com.newBig.system.model.entity.Sale;
import com.newBig.system.model.repository.ClienteRepo;
import com.newBig.system.model.repository.FuncionarioRepo;
import com.newBig.system.model.repository.sale.SaleInterface;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;


public class OpenSale {

    private SaleInterface repositorySale;
    private AddItemToSale addItemToSale;
    private ClienteRepo repositoryCliente;
    private FuncionarioRepo repositoryFuncionario;

    public OpenSale(SaleInterface repositorySale, AddItemToSale addItemToSale, ClienteRepo repositoryCliente, FuncionarioRepo repositoryFuncionario) {
        this.repositorySale = repositorySale;
        this.addItemToSale = addItemToSale;
        this.repositoryCliente = repositoryCliente;
        this.repositoryFuncionario = repositoryFuncionario;
    }

    public Long execute(Long clienteId, Long funcionarioId, Long firstProductId, int quantity, String paymentMethod) {

        // cliente
        Cliente cliente = repositoryCliente.SelecionarCliente(clienteId);
        // funcionario
        Funcionario funcionario = repositoryFuncionario.SelecionarFuncionario(funcionarioId);

        //  = Venda esqueleto que vai servir de ponto de início da venda
        // !!! validações
        Sale sale = new Sale(LocalDateTime.now(), cliente, funcionario, BigDecimal.ZERO, paymentMethod, "ABERTA", new ArrayList<>());
        repositorySale.save(sale);

        addItemToSale.logic(sale.getId(), firstProductId, quantity);

        return sale.getId();
    }


}
