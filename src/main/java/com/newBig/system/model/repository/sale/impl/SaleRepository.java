package com.newBig.system.model.repository.sale.impl;

import com.newBig.system.model.entity.Sale;
import com.newBig.system.model.repository.sale.SaleInterface;
import jakarta.persistence.EntityManager;

import java.util.List;

public class SaleRepository implements SaleInterface {

    private EntityManager em;

    public SaleRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public void save(Sale sale) {
        em.getTransaction().begin();
        em.persist(sale);
        em.getTransaction().commit();
    }

    @Override
    public Sale update(Sale sale) {
        em.getTransaction().begin();
        // O merge atualiza o registro no banco e retorna a instância "gerenciada" pelo JPA
        Sale updatedSale = em.merge(sale);
        em.getTransaction().commit();

        return updatedSale;
    }

    @Override
    public List<Sale> findAll() {
        return em.createQuery(
                        "SELECT s FROM Sale s",
                        Sale.class)
                .getResultList();
    }

    @Override
    public Sale searchById(Long id) {
        return em.find(Sale.class, id);
    }
}
