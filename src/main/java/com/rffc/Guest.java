package com.rffc;

public class Guest {
    private String guestName;
    private int numberOfSessions;
    private double costPerSession; // Added attribute for cost per session

    // Constructor
    public Guest(String guestName, double costPerSession) {
        this.guestName = guestName;
        this.numberOfSessions = 0;
        this.costPerSession = costPerSession;
    }
    
    // overloaded constructor
    public Guest(String guestName, int numberOfSessions) {
        this.guestName = guestName;
        this.numberOfSessions = numberOfSessions;
    }

    // Getter and setter methods
    public String getGuestName() {
        return guestName;
    }

    public int getNumberOfSessions() {
        return numberOfSessions;
    }

    public double getCostPerSession() {
        return costPerSession;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public void setNumberOfSessions(int numberOfSessions) {
        this.numberOfSessions = numberOfSessions;
    }

    public void setCostPerSession(double costPerSession) {
        this.costPerSession = costPerSession;
    }

    // Method to increment the number of sessions
    public void incrementSessions() {
        numberOfSessions++;
    }

    // Method to calculate the total cost for the guest
    public double calculateTotalCost() {
        return numberOfSessions * costPerSession;
    }

    // Method to display guest details
    @Override
    public String toString() {
        return "Guest{" +
                "guestName='" + guestName + '\'' +
                ", numberOfSessions=" + numberOfSessions +
                ", costPerSession=" + costPerSession +
                '}';
    }
}
