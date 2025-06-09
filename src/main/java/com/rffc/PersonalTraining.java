package com.rffc;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PersonalTraining extends Session {
    private Member member;
    private List<Member> enrolledMembers;

    // Additional attribute for cost per session
    private double additionalCost = 10.0;

    // Constructor
    public PersonalTraining(String sessionName, LocalDateTime startTime, int durationMinutes, String instructorName, Member member) {
        super(sessionName, startTime, durationMinutes, instructorName);
        this.member = member;
        this.enrolledMembers = new ArrayList<>();
    }
    
    public PersonalTraining(LocalDateTime startTime, int durationMinutes, String trainername,
            Member member) {
        super(startTime, durationMinutes, trainername);
        this.member = member;
    }

    // Method to calculate the total cost for the personal training session
    public double calculateTotalCost() {
        return getDurationMinutes() * additionalCost;
    }

    // Add a method to enroll a member in the personal training session
    public void addEnrolledMember(Member member) {
        List<PersonalTraining> availablePersonalTrainingSessions;
        if (enrolledMembers.size() < availablePersonalTrainingSessions.size()) {
            enrolledMembers.add(member);
            System.out.println(member.getName() + " successfully enrolled in personal training session.");
        } else {
            System.out.println("Personal training session is at maximum capacity. Enrollment failed.");
        }
    }

    public List<Member> getEnrolledMembers() {
        return enrolledMembers;
    }

    // Method to display personal training details
    @Override
    public String toString() {
        return "PersonalTraining{" +
                "sessionName='" + getSessionName() + '\'' +
                ", startTime=" + getStartTime() +
                ", durationMinutes=" + getDurationMinutes() +
                ", instructorName='" + getTrainerName() + '\'' +
                ", member=" + member.getName() +
                ", additionalCost=" + additionalCost +
                '}';
    }
}
