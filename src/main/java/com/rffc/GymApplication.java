package com.rffc;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * The {@code GymApplication} class represents the main application for managing gym activities.
 * It includes functionality to interact with different UI components and perform various gym-related operations.
 */

public class GymApplication {
    private MembershipController membershipController;
    private Schedule schedule;
    private ReportGenerator reportGenerator;

    /**
     * Constructs a new {@code GymApplication} with default settings.
     */
    public GymApplication() {
        this.reportGenerator = new ReportGenerator();
        this.schedule = new Schedule(new ArrayList<>()); // Assuming an empty list initially
        this.schedule.setReportGenerator(reportGenerator);
    }

    /**
    * Constructs a new {@code GymApplication} with the specified components.
    *
    * @param membershipController The membership controller for managing gym memberships.
    * @param schedule             The schedule for managing gym class schedules.
    * @param reportGenerator      The report generator for generating gym-related reports.
    */
    public GymApplication(MembershipController membershipController, Schedule schedule,
            ReportGenerator reportGenerator) {
        this.membershipController = membershipController;
        this.schedule = schedule;
        this.reportGenerator = reportGenerator;
    }

    // getters and setters
    public void setMembershipController(MembershipController membershipController) {
        this.membershipController = membershipController;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public ReportGenerator getReportGenerator() {
        return reportGenerator;
    }

    public void setReportGenerator(ReportGenerator reportGenerator) {
        this.reportGenerator = reportGenerator;
    }

    public MembershipController getMembershipController() {
        return membershipController;
    }

    public Schedule getSchedule() {
        return null;
    }

    /**
     * The main method to start the gym application and interact with different UI components.
     *
     * @param args The command-line arguments (not used).
     */
    public static void main(String[] args) {
        GymApplication gymApplication = new GymApplication();
        ReportGenerator reportGenerator = new ReportGenerator();
        Inventory inventory = new Inventory();

        Member member = new Member(0, 0, null, null, null, null, 0);

        try {
            // Try to set an invalid age
            member.setAge(16);
            // Other code to handle successful age setting
        } catch (InvalidAgeException e) {
            System.out.println(e.getMessage());
            // Other code to handle invalid age
        }

        // Initialize necessary components
        OnlineUsersUI onlineUsersUI = new OnlineUsersUI(gymApplication, reportGenerator); // Assuming no reference to GymApplication initially

        // Create GymWorkersUI instance and pass necessary components
        GymWorkersUI gymWorkersUI = new GymWorkersUI(gymApplication, reportGenerator, inventory);

        // Create Scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Display main menu
        int mainChoice;
        do {
            System.out.println("--- Main Menu ---");
            System.out.println("1. Gym Worker's UI");
            System.out.println("2. Online Users UI");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            mainChoice = scanner.nextInt();

            switch (mainChoice) {
                case 1:
                    // Start Gym Worker's UI
                    gymWorkersUI.startUI();
                    break;
                case 2:
                    // Start Online Users UI
                    onlineUsersUI.displayOnlineUsers(); // Placeholder action, update as needed
                    break;
                case 3:
                    System.out.println("Exiting Gym Application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (mainChoice != 3);

        // Close the scanner
        scanner.close();
    }

    /**
     * Displays the class schedules for the gym application.
     */
    public void displayClassSchedules() {
    }

    /**
     * Registers a member for a class in the gym application.
     *
     * @param member The member to register.
     */
    public void registerMemberForClass(Member member) {
    }

    /**
     * Checks in a member in the gym application.
     *
     * @param member The member to check in.
     */
    public void checkInMember(Member member) {
    }

    /**
     * Returns a string representation of the {@code GymApplication} object.
     *
     * @return A string representation of the object.
     */
    @Override
    public String toString() {
        return "GymApplication [membershipController=" + membershipController + ", schedule=" + schedule
                + ", reportGenerator=" + reportGenerator + "]";
    }

    
}
