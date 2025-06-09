package com.rffc;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OnlineUsersUI {
    private List<Member> onlineUsers;
    private GymApplication gymApplication;
    private ReportGenerator reportGenerator;
    private List<PersonalTraining> availablePersonalTrainingSessions;
    private static OnlineUsersUI instance;

    public OnlineUsersUI(GymApplication gymApplication, ReportGenerator reportGenerator) {
        this.gymApplication = gymApplication;
        this.onlineUsers = new ArrayList<>(); // Initialize onlineUsers list
        this.reportGenerator = reportGenerator;
        availablePersonalTrainingSessions = new ArrayList<>();
    }

    OnlineUsersUI() {
    }

    public List<PersonalTraining> getAvailablePersonalTrainingSessions() {
        return availablePersonalTrainingSessions;
    }

    // Method to display online users
    public void displayOnlineUsers() {
        System.out.println("\n--- Online Users ---");
        for (Member onlineUser : onlineUsers) {
            System.out.println(onlineUser.getName());
        }
    }

    // Static method to get the singleton instance
    public static OnlineUsersUI getInstance() {
        if (instance == null) {
            instance = new OnlineUsersUI();
        }
        return instance;
    }

    // Method for new member sign-up
    public void signUp() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter your name: ");
            String name = scanner.nextLine();
            System.out.print("Enter your email: ");
            String email = scanner.nextLine();
            System.out.print("Enter your phone number: ");
            String phoneNumber = scanner.nextLine();

            // Assume MembershipPlan is available for selection
            MembershipPlan membershipPlan = selectMembershipPlan();

            Member newMember = new Member(generateMemberId(), name, email, phoneNumber, membershipPlan);
            onlineUsers.add(newMember);

            System.out.println("Sign-up successful! Welcome, " + name + "!");
            System.out.println("Your Member ID is: " + newMember.getMemberId());
        }
    }

    // Method for member login
    public void login() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter your Member ID: ");
            int memberId = scanner.nextInt();

            // Consume the newline character
            scanner.nextLine();

            System.out.print("Enter your phone number: ");
            String phoneNumber = scanner.nextLine();

            Member foundMember = findMemberByIdAndPhoneNumber(memberId, phoneNumber);
            if (foundMember != null) {
                System.out.println("Login successful! Welcome back, " + foundMember.getName() + "!");
                showUserOptions(foundMember);
            } else {
                System.out.println("Member not found with provided Member ID and phone number.");
            }
        }
    }

    // Method to find a member by Member ID and phone number
    private Member findMemberByIdAndPhoneNumber(int memberId, String phoneNumber) {
        for (Member member : onlineUsers) {
            if (member.getMemberId() == memberId && member.getPhoneNumber().equals(phoneNumber)) {
                return member;
            }
        }
        return null;
    }

    // Method to show user options after login
    private void showUserOptions(Member member) {
        try (Scanner scanner = new Scanner(System.in)) {
            int choice;

            do {
                displayUserOptions();
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        viewClassSchedules();
                        break;
                    case 2:
                        registerForClasses(member);
                        break;
                    case 3:
                        System.out.println("Logging out. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                }

            } while (choice != 3);
        }
    }

    // Method to display user options after login
    private void displayUserOptions() {
        System.out.println("\n--- User Options ---");
        System.out.println("1. View Class Schedules");
        System.out.println("2. Register for Classes");
        System.out.println("3. Logout");
    }

    // Method to view class schedules
    public void viewClassSchedules() {
        System.out.println("\n--- Group Fitness Class Schedule ---");
        Schedule schedule = gymApplication.getSchedule();
        List<GroupFitnessClass> monthlySchedule = schedule.getMonthlySchedule();

        for (GroupFitnessClass groupFitnessClass : monthlySchedule) {
            System.out.println("Class Name: " + groupFitnessClass.getClassName());
            System.out.println("Fitness Trainer: " + groupFitnessClass.getFitnessTrainer());
            System.out.println("Start Time: " + groupFitnessClass.getSchedule());
            System.out.println("Max Capacity: " + groupFitnessClass.getMaxCapacity());
            System.out.println(); // Add a newline for better readability
        }
    }

    // Method to register for a class
    public void registerForClasses(Member member) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("\n--- Registration for Classes ---");
            System.out.println("1. Register for Group Fitness Classes");
            System.out.println("2. Register for Personal 1-on-1 Training Sessions");
            System.out.print("Enter your choice (1 or 2): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    registerForGroupFitnessClasses(member);
                    break;
                case 2:
                    registerForPersonalTrainingSessions(member);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter either 1 or 2.");
            }
        }
    }

    // Helper method to register for group fitness classes
    private void registerForGroupFitnessClasses(Member member) {
        Schedule schedule = Schedule.getInstance(); // Assuming Schedule is a singleton
        List<GroupFitnessClass> monthlySchedule = schedule.getMonthlySchedule();

        // Display available group fitness classes
        System.out.println("Available Group Fitness Classes:");
        for (int i = 0; i < monthlySchedule.size(); i++) {
            GroupFitnessClass groupFitnessClass = monthlySchedule.get(i);
            System.out.println((i + 1) + ". " + groupFitnessClass.getClassName() +
                    " with Trainer " + groupFitnessClass.getFitnessTrainer() +
                    " on " + groupFitnessClass.getSchedule());
        }

        // Prompt the member to choose a class to register for
        System.out.print("Enter the number of the class you want to register for: ");
        try (Scanner scanner = new Scanner(System.in)) {
            int classChoice = scanner.nextInt();

            // Validate the class choice
            if (classChoice >= 1 && classChoice <= monthlySchedule.size()) {
                GroupFitnessClass selectedClass = monthlySchedule.get(classChoice - 1);

                // Enroll the member for the selected class
                if (schedule.registerForMember(selectedClass, member)) {
                    System.out.println("Registration successful!");

                    // Update enrolled members in the ReportGenerator class
                    reportGenerator.updateEnrolledMembers(selectedClass, member);
                } else {
                    System.out.println("Registration failed. Please try again.");
                }
            } else {
                System.out.println("Invalid choice. Please enter a valid class number.");
            }
        }
    }

    // Method to generate a unique member ID (for simplicity, you might need a more
    // robust solution)
    private int generateMemberId() {
        // Logic to generate a unique member ID
        return onlineUsers.size() + 1;
    }

    // Method to select a membership plan (for simplicity, you might need a more
    // robust solution)
    private MembershipPlan selectMembershipPlan() {
        // Logic to allow the user to select a membership plan
        // For simplicity, assume there are predefined membership plans
        return new MembershipPlan("Basic Plan", 9.99, 0, null);
    }

    // method to register for personal training class
    private void registerForPersonalTrainingSessions(Member member) {
        System.out.println("\n--- Registration for Personal Training Sessions ---");

        // Get the current date and time
        LocalDateTime now = LocalDateTime.now();

        // Assume there is a method to display available personal training sessions
        displayAvailablePersonalTrainingSessions();

        // Prompt the member to choose a personal training session
        System.out.print("Enter the number of the personal training session you want to register for: ");
        try (Scanner scanner = new Scanner(System.in)) {
            int sessionChoice = scanner.nextInt();

            // Validate the session choice
            if (sessionChoice >= 1 && sessionChoice <= availablePersonalTrainingSessions.size()) {
                PersonalTraining selectedSession = availablePersonalTrainingSessions.get(sessionChoice - 1);

                // Check if the session is at least 24 hours in the future
                if (now.plusHours(24).isBefore(selectedSession.getStartTime())) {
                    // Enroll the member for the selected personal training session
                    selectedSession.addEnrolledMember(member);

                    System.out.println("Registration successful!");
                    System.out.println("You have been charged $10 for the personal training session.");
                } else {
                    System.out.println(
                            "Registration failed. Personal training session must be at least 24 hours in the future.");
                }
            } else {
                System.out.println("Invalid choice. Please enter a valid session number.");
            }
        }
    }

    public void displayAvailablePersonalTrainingSessions() {
        System.out.println("Available Personal Training Sessions:");
        for (int i = 0; i < availablePersonalTrainingSessions.size(); i++) {
            PersonalTraining personalTraining = availablePersonalTrainingSessions.get(i);
            System.out.println((i + 1) + ". " + personalTraining.getSessionName() +
                    " with Trainer " + personalTraining.getTrainerName() +
                    " on " + personalTraining.getStartTime());
        }
    }

}
