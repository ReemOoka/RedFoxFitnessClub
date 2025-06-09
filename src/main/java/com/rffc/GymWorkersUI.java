package com.rffc;

import java.util.Scanner;

public class GymWorkersUI {
    private GymApplication gymApplication;
    private ReportGenerator reportGenerator;
    private Inventory inventory;

    public GymWorkersUI(GymApplication gymApplication, ReportGenerator reportGenerator, Inventory inventory) {
        this.gymApplication = gymApplication;
        this.reportGenerator = reportGenerator;
        this.inventory = inventory;
    }

    public GymWorkersUI(GymApplication gymApplication2) {
    }

    public void startUI() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            displayMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    sellItems();
                    break;
                case 2:
                    trackInventory();
                    break;
                case 3:
                    checkInMember();
                    break;
                case 4:
                    viewReports();
                    break;
                case 5:
                    System.out.println("Exiting Gym Worker's UI. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }

        } while (choice != 5);
        scanner.close();
    }

    private void displayMenu() {
        System.out.println("\n--- Gym Worker's Menu ---");
        System.out.println("1. Sell Items");
        System.out.println("2. Track Inventory");
        System.out.println("3. Check In Member");
        System.out.println("4. View Reports");
        System.out.println("5. Exit");
    }

    private void sellItems() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter product name: ");
            String productName = scanner.nextLine();
    
            // Check if the product is in stock
            if (inventory.isInStock(productName)) {
                Product product = inventory.getProductByName(productName);
    
                System.out.print("Enter quantity: ");
                int quantity = scanner.nextInt();
    
                // Consume the newline character
                scanner.nextLine();
    
                // Record the sale if the quantity is available
                if (inventory.sellProduct(product, quantity)) {
                    // Display the type of product sold along with the quantity
                    System.out.println("Product type sold: " + product.getProductType());
                    System.out.println("Quantity sold: " + quantity);
                    System.out.println("Items sold successfully!");
                } else {
                    System.out.println("Insufficient stock. Sale not recorded.");
                }
            } else {
                System.out.println("Product not found in the inventory or out of stock.");
            }
        }
    }  

    private void trackInventory() {
        try (Scanner scanner = new Scanner(System.in)) {
            int inventoryChoice;
   
            do {
                displayInventoryMenu();
                System.out.print("Enter your choice: ");
                inventoryChoice = scanner.nextInt();
   
                switch (inventoryChoice) {
                    case 1:
                        inventory.displayInventory();
                        break;
                    case 2:
                        addProductToInventory();
                        break;
                    case 3:
                        removeProductFromInventory();
                        break;
                    case 4:
                        updateProductStock();
                        break;
                    case 5:
                        System.out.println("Exiting Inventory Management. Returning to main menu.");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                }
   
            } while (inventoryChoice != 5);
        }
    }
    
    private void displayInventoryMenu() {
        System.out.println("\n--- Inventory Management Menu ---");
        System.out.println("1. View Inventory");
        System.out.println("2. Add Product to Inventory");
        System.out.println("3. Remove Product from Inventory");
        System.out.println("4. Update Product Quantity");
        System.out.println("5. Exit to Main Menu");
    }
    
    private void addProductToInventory() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter product name: ");
            String productName = scanner.nextLine();
            System.out.print("Enter product type (e.g., Drink, Supplement, Merchandise): ");
            String productType = scanner.nextLine();
            System.out.print("Enter product price: ");
            double price = scanner.nextDouble();
            System.out.print("Enter initial quantity: ");
            int initialQuantity = scanner.nextInt();
    
            Product newProduct = new Product(productName, productType, price, initialQuantity);
            inventory.addProduct(newProduct);
    
            System.out.println("Product added to inventory successfully!");
        }
    }
    
    private void removeProductFromInventory() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter product name to remove: ");
            String productName = scanner.nextLine();
    
            inventory.removeProduct(productName);
        }
    }
    
    private void updateProductStock() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter product name: ");
            String productName = scanner.nextLine();
    
            System.out.print("Enter new quantity: ");
            int newQuantity = scanner.nextInt();
    
            // Consume the newline character
            scanner.nextLine();
    
            inventory.updateProductQuantity(productName, newQuantity);
        }
    }   

    private void checkInMember() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter member ID: ");
            int memberId = scanner.nextInt();
    
            // Assume the member is available in the system
            Object membershipControllerObject = gymApplication.getMembershipController();
    
            if (membershipControllerObject instanceof MembershipController) {
                MembershipController membershipController = (MembershipController) membershipControllerObject;
                Member member = membershipController.findMemberById(memberId);
    
                if (member != null) {
                    // Record attendance
                    member.recordAttendance();
    
                    // Add points to the member's account
                    member.addPoints(10);
    
                    // Display check-in success message
                    System.out.println(member.getName() + " checked in successfully!");
                    System.out.println("Attendance recorded. 10 points added to the account.");
                } else {
                    System.out.println("Member not found with ID: " + memberId);
                }
            } else {
                System.out.println("MembershipController not found in GymApplication.");
            }
        }
    }
    

    public void viewReports() {
        // Example logic to view reports
        reportGenerator.generateReport("classAttendance");
    }
}
