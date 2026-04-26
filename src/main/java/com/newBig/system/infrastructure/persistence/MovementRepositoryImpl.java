package com.newBig.system.infrastructure.persistence;

import com.newBig.system.domain.model.StockMovement;
import com.newBig.system.domain.repository.StockMovementRepository;
import jakarta.persistence.EntityManager;

import java.time.LocalDate;
import java.util.List;

public class MovementRepositoryImpl implements StockMovementRepository {

    private EntityManager em;

    public MovementRepositoryImpl(EntityManager em) {
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
