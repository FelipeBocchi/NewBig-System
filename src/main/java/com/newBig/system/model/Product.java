package com.newBig.system.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_name", nullable = false)
    private String productName;
    @Column(name = "description")
    private String description;

    @Column(name = "department")
    private String department;
    @Column(name = "category")
    private String category;

    @Column(name = "bar_code")
    private int barcode;

    @Column(name = "cost_price")
    private BigDecimal costPrice;
    @Column(name = "sale_price")
    private BigDecimal salePrice;

    @Column(name = "minimum_stock")
    private int minimumStock; // A quantidade minima para esse produto

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private ProductType type;
    @Enumerated(EnumType.STRING)
    @Column(name = "unit")
    private UnitType unit;

    //  = Construtor protegido para o JPA
    protected Product() {}

    public Product(String productName, String description, String department, String category, int barcode, BigDecimal costPrice, BigDecimal salePrice, int minimumStock, ProductType type, Product.UnitType unit) {

        this.productName = productName;
        this.description = description;
        this.department = department;
        this.category = category;
        this.barcode = barcode;
        this.costPrice = costPrice;
        this.salePrice = salePrice;
        this.minimumStock = minimumStock;
        this.type = type;
        this.unit = unit;
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

    //  = Métodos criados para funções futuras de self-service =

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

    //  =                                                      =

    //  = Métodos Getting =

    public Long getId() { return id; }

    public String getDepartment() {
        return department;
    }

    public String getCategory() {
        return category;
    }

    public String getProductName() {
        return productName;
    }

    public int getBarcode() {
        return barcode;
    }

    public BigDecimal getSalePrice() { return salePrice; }

    public BigDecimal getCostPrice() { return salePrice; }

    public int getMinimumStock() { return minimumStock; }

    public Product.ProductType getType() { return type; }

    //  =

    //  = Funções Setting =

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public void setCostPrice(BigDecimal costPrice) {
        this.costPrice = costPrice;
    }

    public void setMinimumStock(int minimumStock) {
        this.minimumStock = minimumStock;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setType(ProductType type) {
        this.type = type;
    }

    public void setUnit(UnitType unit) {
        this.unit = unit;
    }

    //  =

}

