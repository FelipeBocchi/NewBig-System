package com.newBig.system.model.repository;

import com.newBig.system.model.entity.Product;
import com.newBig.system.model.entity.SalesMovement;
import jakarta.persistence.EntityManager;

import java.util.List;

public class SalesMovementRepository implements SalesMovementInterface {

    private EntityManager em;

    public SalesMovementRepository(EntityManager em) {
        this.em = em;
    }

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
    public Product searchById(Long id) {
        return em.find(Product.class, id);
    }

    @Override
    public List<SalesMovement> findById(Long id) {
        return em.createQuery(
                        "SELECT s FROM SalesMovement s WHERE s.sale.id = : id",
                        SalesMovement.class)
                .setParameter("id", id)
                .getResultList();
    }

    //b.product.id = : productID
}
