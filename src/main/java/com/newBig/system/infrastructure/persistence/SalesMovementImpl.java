package com.newBig.system.infrastructure.persistence;

import com.newBig.system.domain.model.Product;
import com.newBig.system.domain.model.SalesMovement;
import com.newBig.system.domain.repository.SalesMovementRepository;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.UUID;

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

    @Override
    public Product searchById(UUID id) {
        return em.find(Product.class, id);
    }
}
