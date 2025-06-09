package com.rffc;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Schedule {
    private List<GroupFitnessClass> monthlySchedule;
    private int scheduleMonth;
    private int scheduleYear;

    public Schedule(int scheduleMonth, int scheduleYear) {
        this.scheduleMonth = scheduleMonth;
        this.scheduleYear = scheduleYear;
        this.monthlySchedule = new ArrayList<>();
        // Initialize the schedule with some default classes for demonstration purposes
        initializeDefaultSchedule();
    }

    // overloaded constructor
    public Schedule(List<GroupFitnessClass> monthlySchedule) {
        this.monthlySchedule = monthlySchedule;
    }

    // getters and setters

    public List<GroupFitnessClass> getMonthlySchedule() {
        return monthlySchedule;
    }

    public void setMonthlySchedule(List<GroupFitnessClass> monthlySchedule) {
        this.monthlySchedule = monthlySchedule;
    }

    public int getScheduleMonth() {
        return scheduleMonth;
    }

    public void setScheduleMonth(int scheduleMonth) {
        this.scheduleMonth = scheduleMonth;
    }

    public int getScheduleYear() {
        return scheduleYear;
    }

    public void setScheduleYear(int scheduleYear) {
        this.scheduleYear = scheduleYear;
    }

    // Method to generate the monthly group fitness class schedule
    public void generateMonthlySchedule() {
        // Implement your logic to generate the schedule for the month
        // This might involve fetching data from a database or using predefined
        // templates
        // For demonstration, let's assume some default classes are added
        initializeDefaultSchedule();
    }

    // Method to allow members to register for a group fitness class
    public boolean registerForMember(GroupFitnessClass groupFitnessClass, Member member) {
        if (groupFitnessClass.hasAvailableSlots() && !member.isAlreadyEnrolled(groupFitnessClass)) {
            groupFitnessClass.addEnrolledMember(member);
            System.out.println(member.getName() + " successfully registered for " + groupFitnessClass.getClassName());
            return true;
        } else {
            System.out.println("Registration failed. Class is full or member is already enrolled.");
            return false;
        }
    }

    // Method to display the monthly group fitness class schedule
    public void displayMonthlySchedule() {
        System.out.println("Monthly Schedule for " + getMonthYearString());
        for (GroupFitnessClass groupFitnessClass : monthlySchedule) {
            System.out.println(groupFitnessClass);
        }
    }

    // Method to get the formatted month and year string
    private String getMonthYearString() {
        return scheduleMonth + "/" + scheduleYear;
    }

    // Initialize the schedule with some default classes for demonstration purposes
    private void initializeDefaultSchedule() {
        LocalDateTime now = LocalDateTime.now();

        GroupFitnessClass class1 = new GroupFitnessClass("Zumba", now.plusDays(1), 20, "Ashley");
        GroupFitnessClass class2 = new GroupFitnessClass("Yoga", now.plusDays(3), 15, "Deepika");
        GroupFitnessClass class3 = new GroupFitnessClass("Cardio", now.plusDays(5), 25, "Maxwell");
        GroupFitnessClass class4 = new GroupFitnessClass("Zumba", now.plusDays(2), 15, "Kaitlyn");
        GroupFitnessClass class5 = new GroupFitnessClass("Yoga", now.plusDays(4), 10, "Rahul");
        GroupFitnessClass class6 = new GroupFitnessClass("Cardio", now.plusDays(6), 20, "John");
        GroupFitnessClass class7 = new GroupFitnessClass("Zumba", now.plusDays(7), 10, "Emily");
        GroupFitnessClass class8 = new GroupFitnessClass("Yoga", now.plusDays(7), 10, "Zoya");
        GroupFitnessClass class9 = new GroupFitnessClass("Cardio", now.plusDays(7), 10, "Simon");

        monthlySchedule.add(class1);
        monthlySchedule.add(class2);
        monthlySchedule.add(class3);
        monthlySchedule.add(class4);
        monthlySchedule.add(class5);
        monthlySchedule.add(class6);
        monthlySchedule.add(class7);
        monthlySchedule.add(class8);
        monthlySchedule.add(class9);
    }

    @Override
    public String toString() {
        return "Schedule [monthlySchedule=" + monthlySchedule + ", scheduleMonth=" + scheduleMonth + ", scheduleYear="
                + scheduleYear + "]";
    }
}
