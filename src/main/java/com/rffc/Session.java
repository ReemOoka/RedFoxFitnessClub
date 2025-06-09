package com.rffc;

import java.time.LocalDateTime;

public class Session {
    private String sessionName;
    private LocalDateTime startTime;
    private int durationMinutes;
    private String trainerName;

    // Constructor
    public Session(String sessionName, LocalDateTime startTime, int durationMinutes, String trainername) {
        this.sessionName = sessionName;
        this.startTime = startTime;
        this.durationMinutes = durationMinutes;
        this.trainerName = trainername;
    }

    //overloaded constructor
    public Session(LocalDateTime startTime, int durationMinutes, String trainerName) {
        this.startTime = startTime;
        this.durationMinutes = durationMinutes;
        this.trainerName = trainerName;
    }

    // Getter and setter methods
    public String getSessionName() {
        return sessionName;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public String getTrainerName() {
        return trainerName;
    }

    public void setSessionName(String sessionName) {
        this.sessionName = sessionName;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public void setDurationMinutes(int durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }

    // Method to display session details
    @Override
    public String toString() {
        return "Session{" +
                "sessionName='" + sessionName + '\'' +
                ", startTime=" + startTime +
                ", durationMinutes=" + durationMinutes +
                ", instructorName='" + trainerName + '\'' +
                '}';
    }
}
