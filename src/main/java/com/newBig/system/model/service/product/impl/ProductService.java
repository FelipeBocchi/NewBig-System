package com.newBig.system.model.service.product.impl;

import com.newBig.system.model.entity.Product;
import com.newBig.system.model.repository.product.ProductInterface;
import com.newBig.system.model.service.product.ProductServiceInterface;

import java.math.BigDecimal;
import java.util.List;

public class ProductService implements ProductServiceInterface {

    private ProductInterface repository;

    public ProductService(ProductInterface repository) {
        this.repository = repository;
    }

    public void save(String productName, String description, String department, String category, int barcode, BigDecimal costPrice, BigDecimal salePrice, int minimumStock, Product.ProductType type, Product.UnitType unit ) {

        if (productName == null || productName.isBlank()) throw new IllegalArgumentException("Nome do produto OBRIGATÓRIO!!!");
        if (description == null || description.isBlank()) throw new IllegalArgumentException("Descrição do produto OBRIGATÓRIO!!!");
        if (department == null || department.isBlank()) throw new IllegalArgumentException("Departamento do produto OBRIGATÓRIO!!!");
        if (category == null || category.isBlank()) throw new IllegalArgumentException("Categoria do produto OBRIGATÓRIO!!!");
        if (costPrice.compareTo(BigDecimal.ZERO) < 0) throw new IllegalArgumentException("Preço de custo não pode ser negativo!!!");
        if (salePrice.compareTo(BigDecimal.ZERO) < 0) throw new IllegalArgumentException("Preço de venda não pode ser negativo!!!");
        if (minimumStock <= 0) throw new IllegalArgumentException("Estoque mínimo não pode ser negativo ou Zero!!!");

        Product product = new Product(productName, description, department, category, barcode, costPrice, salePrice, minimumStock, type, unit);
        repository.save(product);
    }

    public Product update(Product product) {
        return repository.update(product);
    }

    public void delete(Product product) {
        repository.delete(product);
    }

    // == Buscas no sistema

    public List<Product> searchByName(String name){
        return repository.searchByName(name);
    }

    public List<Product> searchByBarcode (int barcode){
        return repository.searchByBarcode(barcode);
    }

    public Product searchById (Long id){
        return repository.searchById(id);
    }

    // == Listagem no sistema

    public List<Product> findAll(){
        return repository.findAll();
    }

    public List<Product> findByCategory(String category){
        return repository.findByCategory(category);
    }

    public List<Product> findByType(Product.ProductType type){
        return repository.findByType(type);
    }

    public List<Product> findBySalePrice(BigDecimal price){
        return repository.findBySalePrice(price);
    }

    public List<Product> findByCostPrice(BigDecimal price){
        return repository.findByCostPrice(price);
    }

    public List<Product> findByEqualPrice(BigDecimal price){
        return repository.findByEqualPrice(price);
    }

    public List<Product> findByUnit(Product.UnitType unit){
        return repository.findByUnit(unit);
    }

    public Product findByBarcode(int barcode){
        return repository.findByBarcode(barcode);
    }

}
