package com.rffc;

import java.time.LocalDateTime;
import java.util.List;

public class GroupFitnessClass {
    private String className;
    private LocalDateTime schedule;
    private int maxCapacity;
    private List<Member> enrolledMembers;
    private String fitnessTrainer;

    // Constructor
    public GroupFitnessClass(String className, LocalDateTime schedule, int maxCapacity, String fitnessTrainer) {
        this.className = className;
        this.schedule = schedule;
        this.maxCapacity = maxCapacity;
        this.fitnessTrainer = fitnessTrainer;
    }

    // overloaded constructor
    public GroupFitnessClass(String className, LocalDateTime schedule, int maxCapacity, List<Member> enrolledMembers,
            String fitnessTrainer) {
        this.className = className;
        this.schedule = schedule;
        this.maxCapacity = maxCapacity;
        this.enrolledMembers = enrolledMembers;
        this.fitnessTrainer = fitnessTrainer;
    }

    // Getters and setter methods
    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public LocalDateTime getSchedule() {
        return schedule;
    }

    public void setSchedule(LocalDateTime schedule) {
        this.schedule = schedule;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }
    
    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public List<Member> getEnrolledMembers() {
        return enrolledMembers;
    }

    public void setEnrolledMembers(List<Member> enrolledMembers) {
        this.enrolledMembers = enrolledMembers;
    }

    public String getFitnessTrainer() {
        return fitnessTrainer;
    }

    public void setFitnessTrainer(String fitnessTrainer) {
        this.fitnessTrainer = fitnessTrainer;
    }

    // Method to enroll a member in the class
    public boolean enrollMember(Member member) {
        if (enrolledMembers.size() < maxCapacity) {
            enrolledMembers.add(member);
            return true; // Enrollment successful
        } else {
            System.out.println("Class is at maximum capacity. Enrollment failed.");
            return false; // Enrollment failed
        }
    }

    // Method to check if a member is enrolled in the class
    public boolean isMemberEnrolled(Member member) {
        return enrolledMembers.contains(member);
    }

    // overridden tostring method
    @Override
    public String toString() {
        return "GroupFitnessClass{" +
                "className='" + className + '\'' +
                ", schedule=" + schedule +
                ", maxCapacity=" + maxCapacity +
                ", enrolledMembers=" + enrolledMembers +
                ", fitnessTrainer=" + fitnessTrainer +
                '}';
    }

    public boolean hasAvailableSlots() {
        return false;
    }

    public void addEnrolledMember(Member member) {
    }

    public Session getSession() {
        return null;
    }
}
