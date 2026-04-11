package com.newBig.system.infrastructure.persistence;

import com.newBig.system.domain.model.Batch;
import com.newBig.system.domain.model.Sale;
import com.newBig.system.domain.model.SalesMovement;
import com.newBig.system.domain.repository.SalesMovementRepository;
import jakarta.persistence.EntityManager;

import java.util.List;

public class SalesMovementImpl implements SalesMovementRepository {

    private EntityManager em;

    @Override
    public void save(SalesMovement movement) {
        em.getTransaction().begin();
        em.persist(movement);
        em.getTransaction().commit();
    }

    @Override
    public List<SalesMovement> findAll() {
        return em.createQuery(
                        "SELECT b FROM SalesMovement b",
                        SalesMovement.class)
                .getResultList();
    }
}
