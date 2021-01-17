package com.example.pomodoroworkflow;

public class Task {
    String duration;
    String description;
    String type;
    boolean done = false;

    public Task(String duration, String description, String type) {
        this.duration = duration;
        this.description = description;
        this.type = type;
    }

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
