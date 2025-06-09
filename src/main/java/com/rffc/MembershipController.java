package com.rffc;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class MembershipController implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<Member> members;
    private List<MembershipPlan> availablePlans;

    // Default Constructor
    public MembershipController() {
        this.members = new ArrayList<>();
        this.availablePlans = new ArrayList<>();
        initializePlans(); // Initialize available membership plans
    }

    // overloaded constructor
    public MembershipController(List<Member> members, List<MembershipPlan> availablePlans) {
        this.members = members;
        this.availablePlans = availablePlans;
    }

    // getters and setters
    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    public List<MembershipPlan> getAvailablePlans() {
        return availablePlans;
    }

    public void setAvailablePlans(List<MembershipPlan> availablePlans) {
        this.availablePlans = availablePlans;
    }

    // Method to initialize available membership plans
    private void initializePlans() {
        MembershipPlan basicPlan = new MembershipPlan("Basic Plan", 9.99, 0, List.of("Zumba", "Yoga", "Cardio"));
        MembershipPlan foxPlan = new MembershipPlan("Fox Plan", 19.99, 2,
                List.of("Zumba", "Yoga", "Cardio", "Group Fitness"));

        availablePlans.add(basicPlan);
        availablePlans.add(foxPlan);
    }

    // Method to sell a new membership
    public void sellMembership(int memberId, String name, String email, String phoneNumber, MembershipPlan plan) {
        Member newMember = new Member(memberId, memberId, name, email, phoneNumber, plan, memberId);
        members.add(newMember);
    }

    // Method to switch a member's plan
    public void switchMembershipPlan(int memberId, MembershipPlan newPlan) {
        Member member = findMemberById(memberId);
        if (member != null) {
            member.setMembershipPlan(newPlan);
        } else {
            System.out.println("Member not found with ID: " + memberId);
        }
    }

    // Method to cancel a membership
    public void cancelMembership(int memberId) {
        Member member = findMemberById(memberId);
        if (member != null) {
            members.remove(member);
        } else {
            System.out.println("Member not found with ID: " + memberId);
        }
    }

    // Method to find a member by ID
    public Member findMemberById(int memberId) {
        for (Member member : members) {
            if (member.getMemberId() == memberId) {
                return member;
            }
        }
        return null;
    }

    public void schedulePersonalTrainingOnline(int memberId, LocalDateTime scheduledTime, int durationMinutes,
            String trainerName) {
        Member member = findMemberById(memberId);

        if (member != null) {
            PersonalTraining personalTraining = new PersonalTraining(scheduledTime, durationMinutes, trainerName,
                    member);

            // Check if the scheduled time is valid
            if (validateScheduledTime(scheduledTime)) {
                // Add personal training to member's enrolled sessions
                member.enrollInSession(personalTraining);

                // Display confirmation or additional logic as needed
                System.out.println("Personal training scheduled successfully for member: " + member.getName());
            } else {
                System.out.println("Personal training must be scheduled at least 24 hours ahead.");
            }
        } else {
            System.out.println("Member not found with ID: " + memberId);
        }
    }

    private boolean validateScheduledTime(LocalDateTime scheduledTime) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        LocalDateTime minimumScheduledTime = currentDateTime.plus(24, ChronoUnit.HOURS);
        return scheduledTime.isAfter(minimumScheduledTime);
    }
    
    // Serialization methods
    public void serializeMembershipController() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("membershipController.ser"))) {
            oos.writeObject(this);
            System.out.println("MembershipController serialized successfully.");
        } catch (IOException e) {
            System.out.println("Error during serialization: " + e.getMessage());
        }
    }

    public static MembershipController deserializeMembershipController() {
        MembershipController membershipController = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("membershipController.ser"))) {
            membershipController = (MembershipController) ois.readObject();
            System.out.println("MembershipController deserialized successfully.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error during deserialization: " + e.getMessage());
        }
        return membershipController;
    }

    // overridden tostring method
    @Override
    public String toString() {
        return "MembershipController [members=" + members + ", availablePlans=" + availablePlans + "]";
    }

}
