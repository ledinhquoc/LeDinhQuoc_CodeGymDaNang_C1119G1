package com.codgym.model;

public class OrderDetailInfo {
    private String id;

    private String ProductName;
    private String ProductCode;

    private int quality;
    private double price;
    private double amount;

    public OrderDetailInfo(String id, String productName, String productCode, int quality, double price, double amount) {
        this.id = id;
        ProductName = productName;
        ProductCode = productCode;
        this.quality = quality;
        this.price = price;
        this.amount = amount;
    }

    public OrderDetailInfo() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public String getProductCode() {
        return ProductCode;
    }

    public void setProductCode(String productCode) {
        ProductCode = productCode;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
