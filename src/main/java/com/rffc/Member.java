package com.rffc;

import java.util.List;

public class Member {
    private int memberId;
    private String name;
    private String email;
    private String phoneNumber;
    private MembershipPlan membershipPlan;
    private List<Session> enrolledSessions;
    private int attendanceCount;
    private int points;
    private int accumulatedPoints;
    private List<Guest> guests;

    // Constructor

     public Member(int memberId, String name, String email, String phoneNumber, MembershipPlan membershipPlan,
            List<Session> enrolledSessions, int attendanceCount, int points, int accumulatedPoints,
            List<Guest> guests) {
        this.memberId = memberId;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.membershipPlan = membershipPlan;
        this.enrolledSessions = enrolledSessions;
        this.attendanceCount = attendanceCount;
        this.points = points;
        this.accumulatedPoints = accumulatedPoints;
        this.guests = guests;
    }

    // overloaded constructor

    public Member(int memberId, String name, MembershipPlan membershipPlan, List<Session> enrolledSessions,
            int accumulatedPoints, List<Guest> guests) {
        this.memberId = memberId;
        this.name = name;
        this.membershipPlan = membershipPlan;
        this.enrolledSessions = enrolledSessions;
        this.accumulatedPoints = accumulatedPoints;
        this.guests = guests;
    }

    // Getter and Setter methods for attributes

    public Member(int memberId2, String name2, String email2, String phoneNumber2, MembershipPlan plan) {
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public MembershipPlan getMembershipPlan() {
        return membershipPlan;
    }

    public void setMembershipPlan(MembershipPlan membershipPlan) {
        this.membershipPlan = membershipPlan;
    }

    public List<Session> getEnrolledSessions() {
        return enrolledSessions;
    }

    public void setEnrolledSessions(List<Session> enrolledSessions) {
        this.enrolledSessions = enrolledSessions;
    }

    public int getAccumulatedPoints() {
        return accumulatedPoints;
    }

    public void setAccumulatedPoints(int accumulatedPoints) {
        this.accumulatedPoints = accumulatedPoints;
    }

    public List<Guest> getGuests() {
        return guests;
    }

    public void setGuests(List<Guest> guests) {
        this.guests = guests;
    }

    public int getAttendanceCount() {
        return attendanceCount;
    }

    public void setAttendanceCount(int attendanceCount) {
        this.attendanceCount = attendanceCount;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    // Method to enroll in a session
    public void enrollInSession(PersonalTraining personalTraining) {
        enrolledSessions.add(personalTraining);
    }

    // Method to add guest
    public void addGuest(Guest guest) {
        guests.add(guest);
    }

    //override toString() method

    @Override
    public String toString() {
        return "Member [memberId=" + memberId + ", name=" + name + ", email=" + email + ", phoneNumber=" + phoneNumber
                + ", membershipPlan=" + membershipPlan + ", enrolledSessions=" + enrolledSessions
                + ", accumulatedPoints=" + accumulatedPoints + ", guests=" + guests + "]";
    }

    public boolean isAlreadyEnrolled(GroupFitnessClass groupFitnessClass) {
        return false;
    }

    public void recordAttendance() {
        attendanceCount++;
    }

    public void addPoints(int i) {
        points+=i;
    }

    // Method to redeem points for merchandise discounts
    public void redeemPoints(int pointsToRedeem) {
        int currentPoints = getAccumulatedPoints();

        if (currentPoints >= pointsToRedeem) {
            setAccumulatedPoints(currentPoints - pointsToRedeem);
            double discountAmount = pointsToRedeem / (double) PointSystem.POINTS_PER_DOLLAR_DISCOUNT;
            System.out.println(getName() + " redeemed " + pointsToRedeem + " points for a discount of $" + discountAmount);
        } else {
            System.out.println("Insufficient points for redemption.");
        }
    }

    // Method to display member's accumulated points
    public void displayPoints() {
        System.out.println("Accumulated Points for " + getName() + ": " + accumulatedPoints);
    }
}
