package com.rffc;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Sales implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<Product> soldProducts;
    private int totalDrinkSales;
    private int totalMerchandiseSales;

    // Constructor
    public Sales() {
        this.soldProducts = new ArrayList<>();
        this.totalDrinkSales = 0;
        this.totalMerchandiseSales = 0;
    }

    // Method to record a sale
    public void recordSale(Product product, int quantitySold) {
        soldProducts.add(product);

        // Update total sales for drinks or merchandise based on product type
        if ("drink".equalsIgnoreCase(product.getProductType())) {
            totalDrinkSales += quantitySold;
        } else if ("merchandise".equalsIgnoreCase(product.getProductType())) {
            totalMerchandiseSales += quantitySold;
        }

        System.out.println("Sale recorded: " + quantitySold + " units of " + product.getProductName());
    }

    // Method to display sales information
    public void displaySales() {
        System.out.println("\n--- Sales Information ---");
        System.out.println("Total Drink Sales: " + totalDrinkSales);
        System.out.println("Total Merchandise Sales: " + totalMerchandiseSales);
        System.out.println("Total Sales: " + calculateTotalSales());
        System.out.println("Total Revenue: " + calculateTotalRevenue());
    }

    // Method to calculate total sales
    private int calculateTotalSales() {
        return soldProducts.size();
    }

    // Method to calculate total revenue
    private double calculateTotalRevenue() {
        double totalRevenue = 0;
        for (Product product : soldProducts) {
            totalRevenue += product.getPrice();
        }
        return totalRevenue;
    }

    // Serialization methods
    public void serializeSales() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("sales.ser"))) {
            oos.writeObject(this);
            System.out.println("Sales serialized successfully.");
        } catch (IOException e) {
            System.out.println("Error during serialization: " + e.getMessage());
        }
    }

    public static Sales deserializeSales() {
        Sales sales = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("sales.ser"))) {
            sales = (Sales) ois.readObject();
            System.out.println("Sales deserialized successfully.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error during deserialization: " + e.getMessage());
        }
        return sales;
    }

}
