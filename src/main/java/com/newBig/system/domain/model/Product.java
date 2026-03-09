package com.newBig.system.domain.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.UUID;

public class Product {

    private UUID id;

    private String productName;
    private String description;

    private String department;
    private String category;

    private String sku;
    private int barcode;

    private BigDecimal costPrice;
    private BigDecimal salePrice;

    private int stock;
    private int minimumStock;

    private ProductType type;
    private UnitType  unit;
    // lote para validade
    private LocalDate expirationDate;
    private String batch;

    public Product(String productName, String description, String department, String category, String sku, int barcode, BigDecimal costPrice, BigDecimal salePrice, int stock, int minimumStock, ProductType type, UnitType unit) {

        if (productName == null || productName.isBlank()) throw new IllegalArgumentException("Nome do produto OBRIGATÓRIO!!!");
        if (description == null || description.isBlank()) throw new IllegalArgumentException("Descrição do produto OBRIGATÓRIO!!!");
        if (department == null || department.isBlank()) throw new IllegalArgumentException("Departamento do produto OBRIGATÓRIO!!!");
        if (category == null || category.isBlank()) throw new IllegalArgumentException("Categoria do produto OBRIGATÓRIO!!!");
        if (sku == null || sku.isBlank()) throw new IllegalArgumentException("SKU do produto OBRIGATÓRIO!!!");
        if (costPrice.compareTo(BigDecimal.ZERO) < 0) throw new IllegalArgumentException("Preço de custo não pode ser negativo!!!");
        if (salePrice.compareTo(BigDecimal.ZERO) < 0) throw new IllegalArgumentException("Preço de venda não pode ser negativo!!!");
        if (stock <= 0) throw new IllegalArgumentException("Estoque não pode ser negativo ou Zero!!!");
        if (minimumStock <= 0) throw new IllegalArgumentException("Estoque mínimo não pode ser negativo ou Zero!!!");

        this.id = UUID.randomUUID();
        this.productName = productName;
        this.description = description;
        this.department = department;
        this.category = category;
        this.sku = sku;
        this.barcode = barcode;
        this.costPrice = costPrice;
        this.salePrice = salePrice;
        this.stock = stock;
        this.minimumStock = minimumStock;
        this.type = type;
        this.unit = unit;
        //this.expirationDate = expirationDate;
        //this.batch = batch;
    }


    public enum ProductType {
        PRODUCT,
        INGREDIENT,
        TOPPING,
        COMBO
    }

    public enum UnitType {
        UNIT,
        KG,
        LITER,
        ML
    }

    // == Metodo para callcular a margem de lucro do próprio produto
    public BigDecimal calculateMargin() {

        BigDecimal profit = salePrice.subtract(costPrice);

        return profit
                .divide(costPrice, 2, RoundingMode.HALF_UP)
                .multiply(new BigDecimal("100"));
    }

    // == Função para validar se tem a quantidade no estoque
    public boolean hasStock(int quantity){
        return stock >= quantity;
    }

    // == Função para decrementar o estoque desse produto
    public void decreaseStock(int quantity){

        if(quantity > stock){
            throw new IllegalArgumentException("Estoque insuficiente");
        }

        stock -= quantity;
    }

    // == Função para acrementar o estoque desse produto
    public void increaseStock(int quantity){
        stock += quantity;
    }

    // == Metodo para validar se o produto atingiu o estoque minimo
    public boolean isLowStock(){
        return stock <= minimumStock;
    }

    public boolean isIceCream() {
        return type == ProductType.PRODUCT;
    }

    public boolean isCombo() {
        return type == ProductType.COMBO;
    }

    public boolean isIngredient() {
        return type == ProductType.INGREDIENT;
    }

    public boolean isTopping() {
        return type == ProductType.TOPPING;
    }

    public UUID getId() { return id; }

    public String getDepartment() {
        return department;
    }

    public String getCategory() {
        return category;
    }

    public String getProductName() {
        return productName;
    }

    public String getSku() {
        return sku;
    }

    public int getBarcode() {
        return barcode;
    }


    public int getStock() {
        return stock;
    }
}
