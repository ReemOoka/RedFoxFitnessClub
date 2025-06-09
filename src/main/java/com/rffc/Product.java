package com.rffc;

public class Product {
    private String productName;
    private String productType;
    private double price;
    private int quantity;

    // Constructor
    public Product(String productName, String productType, double price) {
        this.productName = productName;
        this.productType = productType;
        this.price = price;
    }

    // overloaded constructor
    public Product(String productName, String productType, double price, int quantity) {
        this.productName = productName;
        this.productType = productType;
        this.price = price;
        this.quantity = quantity;
    }

    // Getter and setter methods
    public String getProductName() {
        return productName;
    }

    public String getProductType() {
        return productType;
    }

    public double getPrice() {
        return price;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    // Method to display product details

    @Override
    public String toString() {
        return "Product [productName=" + productName + ", productType=" + productType + ", price=" + price
                + ", quantity=" + quantity + "]";
    }

    public boolean isInStock() {
        return false;
    }
    
    public int getQuantity() {
        return 0;
    }

    public void setQuantity(int i) {
    }
}
