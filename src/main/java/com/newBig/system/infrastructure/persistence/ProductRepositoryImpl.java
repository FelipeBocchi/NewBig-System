package com.newBig.system.infrastructure.persistence;

import com.newBig.system.domain.model.Product;
import com.newBig.system.domain.repository.ProductRepository;

import jakarta.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class ProductRepositoryImpl implements ProductRepository {

    private EntityManager em;

    public ProductRepositoryImpl(EntityManager em) {
        this.em = em;
    }


    @Override
    public void save(Product product) {
        em.getTransaction().begin();
        em.persist(product);
        em.getTransaction().commit();
    }

    @Override
    public void delete(Product product) {

    }

    @Override
    public List<Product> searchByName(String name) {
        return em.createQuery(
          "SELECT p FROM product p WHERE LOWER(p.productName) LIKE LOWER(:name)",
                Product.class)
                .setParameter("name", "%" + name + "%")
                .getResultList();
    }

    @Override
    public List<Product> searchByBarcode(int barcode) {
        return em.createQuery(
                "SELECT p FROM product p WHERE p.barcode = :bar",
                Product.class)
                .setParameter("bar", barcode)
                .getResultList();
    }

    @Override
    public Product searchById(UUID id) {
        return em.find(Product.class, id);
    }

    @Override
    public List<Product> findAll() {
        return em.createQuery(
                "SELECT p FROM Product p",
                Product.class)
                .getResultList();
    }

    @Override
    public List<Product> findByCategory(String category) {
        return em.createQuery(
                "SELECT c FROM Product p WHERE p.category = :cat",
                Product.class)
                .setParameter("cat", category)
                .getResultList();
    }

    @Override
    public List<Product> findByType(Product.ProductType type) {
        return em.createQuery(
                "SELECT p FROM Product p WHERE p.type = :type",
                Product.class)
                .setParameter("type", type)
                .getResultList();
    }

    @Override
    public List<Product> findBySalePrice(BigDecimal price) {
        return em.createQuery(
                "SELECT p FROM Product p WHERE p.salePrice <= :price",
                Product.class)
                .setParameter("price", price)
                .getResultList();
    }

    @Override
    public List<Product> findByCostPrice(BigDecimal price) {
        return em.createQuery(
                        "SELECT p FROM Product p WHERE p.costPrice <= :price",
                        Product.class)
                .setParameter("price", price)
                .getResultList();
    }

    @Override
    public List<Product> findByEqualPrice(BigDecimal price) {
        return em.createQuery(
                        "SELECT p FROM Product p WHERE p.salePrice = :price",
                        Product.class)
                .setParameter("price", price)
                .getResultList();
    }

    @Override
    public List<Product> findByUnit(Product.UnitType unit) {
        return em.createQuery(
                "SELECT p FROM Product p WHERE p.unit = :unit",
                Product.class)
                .setParameter("unit", unit)
                .getResultList();
    }
}
