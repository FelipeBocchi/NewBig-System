package com.newBig.system.model.repository.product;

import com.newBig.system.model.entity.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductInterface {

    //  == Create
    void save(Product product);

    //  == Update
    Product update(Product product);

    //  == Delete
    void delete(Product product);

    // == Buscas no sistema
    List<Product> searchByName (String name);
    List<Product> searchByBarcode (int barcode);
    Product searchById (Long id);

    // == Listagem no sistema
    List<Product> findAll();
    List<Product> findByCategory(String category);
    List<Product> findByType(Product.ProductType type);
    List<Product> findBySalePrice(BigDecimal price);
    List<Product> findByCostPrice(BigDecimal price);
    List<Product> findByEqualPrice(BigDecimal price);
    List<Product> findByUnit(Product.UnitType unit);
    Product findByBarcode(int barcode);

}
