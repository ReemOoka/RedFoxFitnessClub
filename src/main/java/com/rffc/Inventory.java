package com.rffc;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Product> products;
    private Sales sales;

    // Constructor
    public Inventory() {
        this.products = new ArrayList<>();
        this.sales = new Sales();
        initializeDefaultInventory();
    }

    // Method to initialize default inventory
    private void initializeDefaultInventory() {
        // Add two examples of each product type to the inventory
        addProduct(new Product("Energy Drink", "Drink", 3.99, 10));
        addProduct(new Product("Protein Shake", "Drink", 4.99, 15));

        addProduct(new Product("Gym T-Shirt", "Merchandise", 14.99, 20));
        addProduct(new Product("Water Bottle", "Merchandise", 5.99, 30));
    }

    // Method to add a product to the inventory
    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Product added to inventory: " + product.getProductName());
    }

    // Method to display the current inventory
    public void displayInventory() {
        System.out.println("Current Inventory:");
        for (Product product : products) {
            System.out.println(product);
        }
    }

    // Method to record a sale and update total sales and revenue
    public void recordSale(Product product, int quantitySold) {
        if (products.contains(product) && product.getQuantity() >= quantitySold) {
            product.setQuantity(product.getQuantity() - quantitySold);
            sales.recordSale(product, quantitySold);
        } else {
            System.out.println("Sale not recorded. Product not available or insufficient stock.");
        }
    }

    // Method to display sales information
    public void displaySales() {
        sales.displaySales();
    }

    public boolean isInStock(String productName) {
        return true;
    }

    public Product getProductByName(String productName) {
        return null;
    }

    public boolean sellProduct(Product product, int quantity) {
        if (products.contains(product) && product.getQuantity() >= quantity) {
            product.setQuantity(product.getQuantity() - quantity);
            sales.recordSale(product, quantity);
            return true; // Indicate a successful sale
        } else {
            System.out.println("Sale not recorded. Product not available or insufficient stock.");
            return false; // Indicate an unsuccessful sale
        }
    }
    

    public void removeProduct(String productName) {
    }

    // Method to update the quantity of a product in the inventory
    public void updateProductQuantity(String productName, int newQuantity) {
        Product product = getProductByName(productName);
        if (product != null) {
            product.setQuantity(newQuantity);
            System.out.println("Quantity updated for product: " + productName);
        } else {
            System.out.println("Product not found in the inventory.");
        }
    }

}

