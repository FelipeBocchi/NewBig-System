package com.newBig.system.repository;

import com.newBig.system.model.StockMovement;
import jakarta.persistence.EntityManager;

import java.time.LocalDate;
import java.util.List;

public class StockMovementRepository implements StockMovementInterface {

    private EntityManager em;

    public StockMovementRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public void saveMovement(StockMovement stockMovement) {
        em.getTransaction().begin();
        em.persist(stockMovement);
        em.getTransaction().commit();
    }

    @Override
    public List<StockMovement> searchByTime(LocalDate day) {
        return em.createQuery(
                        "SELECT s FROM StockMovement s WHERE s.date = :day",
                        StockMovement.class)
                .setParameter("day", day)
                .getResultList();
    }

    @Override
    public List<StockMovement> findAll() {
        return em.createQuery(
                        "SELECT s FROM StockMovement s",
                        StockMovement.class)
                .getResultList();
    }
}
