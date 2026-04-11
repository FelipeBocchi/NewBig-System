package com.newBig.system.infrastructure.persistence;

import com.newBig.system.domain.model.Product;
import com.newBig.system.domain.model.Sale;
import com.newBig.system.domain.repository.SalesRepository;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.UUID;

public class SaleRepositoryImpl implements SalesRepository {

    private EntityManager em;

    @Override
    public void save(Sale sale) {
        em.getTransaction().begin();
        em.persist(sale);
        em.getTransaction().commit();
    }

    @Override
    public List<Sale> findAll() {
        return List.of();
    }


    @Override
    public Sale searchById(Long id) {
        return em.find(Sale.class, id);
    }
}
