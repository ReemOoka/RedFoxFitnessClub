package com.rffc;

import java.util.List;

public class MembershipPlan {
    // Attributes
    private String planName;
    private double monthlyCost;
    private int allowedGuests;
    private List<String> includedGroupFitnessClasses;  // Assuming group fitness classes are represented by their names

    // Default Constructor
    public MembershipPlan() {
        // Initialize attributes with default values or leave them null
    }

    // Overloaded Constructor
    public MembershipPlan(String planName, double monthlyCost, int allowedGuests, List<String> includedGroupFitnessClasses) {
        this.planName = planName;
        this.monthlyCost = monthlyCost;
        this.allowedGuests = allowedGuests;
        this.includedGroupFitnessClasses = includedGroupFitnessClasses;
    }

    // Getter and Setter methods for attributes
    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public double getMonthlyCost() {
        return monthlyCost;
    }

    public void setMonthlyCost(double monthlyCost) {
        this.monthlyCost = monthlyCost;
    }

    public int getAllowedGuests() {
        return allowedGuests;
    }

    public void setAllowedGuests(int allowedGuests) {
        this.allowedGuests = allowedGuests;
    }

    public List<String> getIncludedGroupFitnessClasses() {
        return includedGroupFitnessClasses;
    }

    public void setIncludedGroupFitnessClasses(List<String> includedGroupFitnessClasses) {
        this.includedGroupFitnessClasses = includedGroupFitnessClasses;
    }

    // Overridden toString method
    @Override
    public String toString() {
        return "MembershipPlan{" +
                "planName='" + planName + '\'' +
                ", monthlyCost=" + monthlyCost +
                ", allowedGuests=" + allowedGuests +
                ", includedGroupFitnessClasses=" + includedGroupFitnessClasses +
                '}';
    }
}
