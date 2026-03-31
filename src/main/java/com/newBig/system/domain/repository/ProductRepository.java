package com.newBig.system.domain.repository;

import com.newBig.system.domain.model.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public interface ProductRepository {

    void save(Product product);

    void delete(Product product);

    // == Buscas no sistema
    List<Product> searchByName (String name);
    List<Product> searchBySku (String sku);
    List<Product> searchByBarcode (int barcode);
    Product searchById (UUID id);

    // == Listagem no sistema
    List<Product> findAll();
    List<Product> findByCategory(String category);
    List<Product> findByType(Product.ProductType type);
    List<Product> findBySalePrice(BigDecimal price);
    List<Product> findByCostPrice(BigDecimal price);
    List<Product> findByEqualPrice(BigDecimal price);
    List<Product> findByUnit(Product.UnitType type);


}
