package com.newBig.system.domain.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.UUID;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

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
    private UnitType  unit;

    //  = Construtor protegido para o JPA
    protected Product() {}

    public Product(String productName, String description, String department, String category, int barcode, BigDecimal costPrice, BigDecimal salePrice, int minimumStock, ProductType type, UnitType unit) {

        if (productName == null || productName.isBlank()) throw new IllegalArgumentException("Nome do produto OBRIGATÓRIO!!!");
        if (description == null || description.isBlank()) throw new IllegalArgumentException("Descrição do produto OBRIGATÓRIO!!!");
        if (department == null || department.isBlank()) throw new IllegalArgumentException("Departamento do produto OBRIGATÓRIO!!!");
        if (category == null || category.isBlank()) throw new IllegalArgumentException("Categoria do produto OBRIGATÓRIO!!!");
        if (costPrice.compareTo(BigDecimal.ZERO) < 0) throw new IllegalArgumentException("Preço de custo não pode ser negativo!!!");
        if (salePrice.compareTo(BigDecimal.ZERO) < 0) throw new IllegalArgumentException("Preço de venda não pode ser negativo!!!");
        if (minimumStock <= 0) throw new IllegalArgumentException("Estoque mínimo não pode ser negativo ou Zero!!!");

        //this.id = UUID.randomUUID(); // remove
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

    public int getBarcode() {
        return barcode;
    }

    public BigDecimal getSalePrice() { return salePrice; }

    public BigDecimal getCostPrice() { return salePrice; }

    public int getMinimumStock() { return minimumStock; }

    public ProductType getType() { return type; }

}


