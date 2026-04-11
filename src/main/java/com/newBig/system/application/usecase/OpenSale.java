package com.newBig.system.application.usecase;

import com.newBig.system.domain.model.*;
import jakarta.persistence.EntityManager;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

public class OpenSale {
    private final EntityManager em;
    private final AddItemToSale addItemToSale; // Reutilizamos o outro UseCase

    public OpenSale(EntityManager em, AddItemToSale addItemToSale) {
        this.em = em;
        this.addItemToSale = addItemToSale;
    }

    public Long execute(Long clienteId, Long funcionarioId, UUID firstProductId, int quantity, String paymentMethod) {
        em.getTransaction().begin();
        try {
            Cliente cliente = em.find(Cliente.class, clienteId);
            Funcionario func = em.find(Funcionario.class, funcionarioId);

            // 1. Cria a venda básica (total zero ainda)
            Sale sale = new Sale(LocalDateTime.now(), cliente, func, BigDecimal.ZERO, paymentMethod, "ABERTA", new ArrayList<>());
            em.persist(sale);
            em.flush(); // Garante que o ID da venda seja gerado antes de prosseguir

            // 2. Adiciona o primeiro item usando a lógica de estoque (reutilizando o outro UseCase)
            // Note: passamos 'false' para não comitar a transação aqui dentro, pois o AbrirVenda controla o commit
            addItemToSale.adicionarLogica(sale.getId(), firstProductId, quantity);

            em.getTransaction().commit();
            return sale.getId();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            throw e;
        }
    }
}
