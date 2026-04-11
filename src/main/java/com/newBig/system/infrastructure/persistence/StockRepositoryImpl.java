package com.newBig.system.infrastructure.persistence;

import com.newBig.system.domain.model.Batch;
import com.newBig.system.domain.repository.StockRepository;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.UUID;

public class StockRepositoryImpl implements StockRepository {

    private EntityManager em;

    public StockRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public void save(Batch batch) {
        em.getTransaction().begin();
        em.persist(batch);
        em.getTransaction().commit();
    }

    @Override
    public List<Batch> findAll() {
        return em.createQuery(
                "SELECT b FROM Batch b",
                Batch.class)
                .getResultList();
    }

    @Override
    public List<Batch> findById(UUID productID) {
        return em.createQuery(
                "SELECT b FROM Batch b WHERE b.product.id = : productID",
                Batch.class)
                .setParameter("productID", productID)
                .getResultList();
    }


}
