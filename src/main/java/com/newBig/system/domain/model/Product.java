package com.newBig.system.domain.model;

public class Product {
    private String department;
    private String category;
    private String productName;
    private String sku;
    private int barcode;
    private double price;
    private int stock;
    // lote para validade

    public Product(String department, String category, String product, String sku, int barcode, double price, int stock) {
        if (price < 0){
            throw new IllegalArgumentException("Preço não pode ser negativo");
        }
        this.department = department;
        this.category = category;
        this.productName = product;
        this.sku = sku;
        this.barcode = barcode;
        this.price = price;
        this.stock = stock;
    }

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

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }
}
