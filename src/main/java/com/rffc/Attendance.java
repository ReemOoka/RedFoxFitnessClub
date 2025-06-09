package com.rffc;

import java.time.LocalDateTime;

public class Attendance {
    private Session session;
    private Member member;
    private LocalDateTime checkInTime;

    // Constructor
    public Attendance(Session session, Member member, LocalDateTime checkInTime) {
        this.session = session;
        this.member = member;
        this.checkInTime = checkInTime;
    }

    // overloaded constructor
    public Attendance(Session session, Member member) {
        this.session = session;
        this.member = member;
    }

    // Getter and setter methods
    public Session getSession() {
        return session;
    }

    public Member getMember() {
        return member;
    }

    public LocalDateTime getCheckInTime() {
        return checkInTime;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public void setCheckInTime(LocalDateTime checkInTime) {
        this.checkInTime = checkInTime;
    }

    // Method to display attendance details
    @Override
    public String toString() {
        return "Attendance{" +
                "session=" + session.getSessionName() +
                ", member=" + member.getName() +
                ", checkInTime=" + checkInTime +
                '}';
    }
}
