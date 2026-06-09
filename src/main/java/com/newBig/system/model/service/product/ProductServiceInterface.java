package com.newBig.system.model.service.product;

import com.newBig.system.model.entity.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductServiceInterface {

    void save(String productName, String description, String department, String category, int barcode, BigDecimal costPrice, BigDecimal salePrice, int minimumStock, Product.ProductType type, Product.UnitType unit );

    Product update(Product product);

    void delete(Product product);

    List<Product> searchByName(String name);

    List<Product> searchByBarcode (int barcode);

    Product searchById (Long id);

    List<Product> findAll();

    List<Product> findByCategory(String category);

    List<Product> findByType(Product.ProductType type);

    List<Product> findBySalePrice(BigDecimal price);

    List<Product> findByCostPrice(BigDecimal price);

    List<Product> findByEqualPrice(BigDecimal price);

    List<Product> findByUnit(Product.UnitType unit);

    Product findByBarcode(int barcode);

}
