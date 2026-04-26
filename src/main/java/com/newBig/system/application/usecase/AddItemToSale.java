package com.newBig.system.application.usecase;

import com.newBig.system.domain.model.*;
import jakarta.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class AddItemToSale {
    private final EntityManager em;

    public AddItemToSale(EntityManager em) {
        this.em = em;
    }

    // (cada bip novo)
    public void execute(Long saleId, UUID productId, int quantity) {
        em.getTransaction().begin();  // inicializa uma transação
        try {
            adicionarLogica(saleId, productId, quantity);
            em.getTransaction().commit(); // salva tudo ok
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback(); // desfaz tudo se hover erro
            throw e;
        }
    }

    // A JOIN e FEFO
    public void adicionarLogica(Long saleId, UUID productId, int quantity) {
        Sale sale = em.find(Sale.class, saleId);

        // JOIN FETCH: Pega o lote e o produto de uma vez só (Performance!)
        List<Batch> batches = em.createQuery(
                        "SELECT b FROM Batch b JOIN FETCH b.product p WHERE p.id = :prodId AND b.amount > 0 ORDER BY b.validity ASC",
                        Batch.class)
                .setParameter("prodId", productId)
                .getResultList();

        Stock stockManager = new Stock(batches);
        stockManager.buy(productId, quantity);

        for (Batch b : stockManager.getBatchesBuy()) {
            StockMovement mStock = new StockMovement("SAIDA", b, quantity, b.getProduct().getSalePrice());
            em.persist(mStock);

            SalesMovement sMov = new SalesMovement(sale, mStock);
            em.persist(sMov);


        }
    }
}
