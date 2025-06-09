package com.rffc;

import java.util.HashMap;
import java.util.Map;

public class ReportGenerator {
    private Map<String, Integer> enrolledMembers;
    private Map<String, Integer> attendedMembers;
    private Map<String, Double> classAttendancePercentage; 

    public ReportGenerator() {
        this.enrolledMembers = new HashMap<>();
        this.attendedMembers = new HashMap<>();
        this.classAttendancePercentage = new HashMap<>();
    }

    // overloaded constructor
    public ReportGenerator(Map<String, Double> classAttendancePercentage) {
        this.classAttendancePercentage = classAttendancePercentage;
    }

    public Map<String, Integer> getEnrolledMembers() {
        return enrolledMembers;
    }

    public void setEnrolledMembers(Map<String, Integer> enrolledMembers) {
        this.enrolledMembers = enrolledMembers;
    }

    public Map<String, Integer> getAttendedMembers() {
        return attendedMembers;
    }

    public void setAttendedMembers(Map<String, Integer> attendedMembers) {
        this.attendedMembers = attendedMembers;
    }

    public Map<String, Double> getClassAttendancePercentage() {
        return classAttendancePercentage;
    }

    public void setClassAttendancePercentage(Map<String, Double> classAttendancePercentage) {
        this.classAttendancePercentage = classAttendancePercentage;
    }

    // Method to record member enrollment for a specific class
    public void enrollMember(String className, int memberId) {
        String key = generateKey(className, memberId);
        enrolledMembers.put(key, enrolledMembers.getOrDefault(key, 0) + 1);
    }

    // Method to record member attendance for a specific class
    public void markAttendance(String className, int memberId) {
        String key = generateKey(className, memberId);
        attendedMembers.put(key, attendedMembers.getOrDefault(key, 0) + 1);
        calculateAttendancePercentage(className); // Update the attendance percentage
    }

    // Method to calculate attendance percentage for a specific class
    private void calculateAttendancePercentage(String className) {
        int enrolledCount = enrolledMembers.getOrDefault(className, 0);
        int attendedCount = attendedMembers.getOrDefault(className, 0);
        double percentage = (enrolledCount > 0) ? ((double) attendedCount / enrolledCount) * 100 : 0;
        classAttendancePercentage.put(className, percentage);
    }

    // Method to generate and display the report
    public void generateReport(String reportType) {
        switch (reportType) {
            case "classAttendance":
                generateClassAttendanceReport();
                break;
            // Add more cases for different report types if needed
            default:
                System.out.println("Invalid report type.");
        }
    }

    // Method to generate a class attendance report
    private void generateClassAttendanceReport() {
        System.out.println("Class Attendance Report:");
        for (Map.Entry<String, Integer> entry : enrolledMembers.entrySet()) {
            String className = entry.getKey();
            int enrolledCount = entry.getValue();
            int attendedCount = attendedMembers.getOrDefault(className, 0);
            double attendancePercentage = classAttendancePercentage.getOrDefault(className, 0.0);
            System.out.println("Class: " + className + ", Enrolled: " + enrolledCount +
                    ", Attended: " + attendedCount + ", Attendance Percentage: " + attendancePercentage + "%");
        }
    }

    // Method to generate a unique key for a class and member combination
    private String generateKey(String className, int memberId) {
        return className + "_" + memberId;
    }

    @Override
    public String toString() {
        return "ReportGenerator [enrolledMembers=" + enrolledMembers + ", attendedMembers=" + attendedMembers
                + ", classAttendancePercentage=" + classAttendancePercentage + "]";
    }
}
