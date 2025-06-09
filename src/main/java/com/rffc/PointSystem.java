package com.rffc;

public class PointSystem {
    public static final int POINTS_PER_ATTENDANCE = 10;
    public static final int POINTS_PER_DOLLAR_DISCOUNT = 100;

    // Method to award points to a member for attending the gym
    public static void awardPoints(Member member) {
        member.setAccumulatedPoints(member.getAccumulatedPoints() + POINTS_PER_ATTENDANCE);
    }

    // Method to redeem points for merchandise discounts
    public static void redeemPoints(Member member, int pointsToRedeem) {
        int currentPoints = member.getAccumulatedPoints();

        if (currentPoints >= pointsToRedeem) {
            member.setAccumulatedPoints(currentPoints - pointsToRedeem);
            double discountAmount = pointsToRedeem / (double) POINTS_PER_DOLLAR_DISCOUNT;
            System.out.println(member.getName() + " redeemed " + pointsToRedeem + " points for a discount of $" + discountAmount);
        } else {
            System.out.println("Insufficient points for redemption.");
        }
    }

    // Method to display member's accumulated points
    public void displayPoints(Member member) {
        System.out.println("Accumulated Points for " + member.getName() + ": " + member.getAccumulatedPoints());
    }
}
