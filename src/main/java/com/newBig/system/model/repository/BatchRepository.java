package com.newBig.system.model.repository;

import com.newBig.system.model.entity.Batch;
import jakarta.persistence.EntityManager;

import java.util.List;

public class BatchRepository implements BatchInterface {

    private EntityManager em;

    public BatchRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public void save(Batch batch) {
        em.getTransaction().begin();
        em.persist(batch);
        em.getTransaction().commit();
    }

    @Override
    public void delete(Batch batch) {
        em.getTransaction().begin();
        // Para deletar, o JPA exige que a entidade esteja "gerenciada".
        // Se não estiver, fazemos o merge primeiro e depois removemos.
        Batch managedBatch = em.contains(batch) ? batch : em.merge(batch);
        em.remove(managedBatch);
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
    public List<Batch> findById(Long productID) {
        return em.createQuery(
                        "SELECT b FROM Batch b WHERE b.product.id = : productID",
                        Batch.class)
                .setParameter("productID", productID)
                .getResultList();
    }

    @Override
    public Batch searchById(Long batchId) {
        return em.find(Batch.class, batchId);
    }

    @Override
    public List<Batch> joinBatchAndProduct(Long productId) {
        return em.createQuery(
                        "SELECT b FROM Batch b JOIN FETCH b.product p WHERE p.id = :prodId AND b.amount > 0 ORDER BY b.validity ASC",
                        Batch.class)
                .setParameter("prodId", productId)
                .getResultList();
    }
}
