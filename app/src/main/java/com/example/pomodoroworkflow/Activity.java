package com.example.pomodoroworkflow;

public class Activity {
    String duration;
    String description;

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    Activity(String duration, String description) {
        this.duration = duration;
        this.description = description;
    }
}
