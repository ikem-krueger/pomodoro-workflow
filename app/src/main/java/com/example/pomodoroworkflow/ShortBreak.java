package com.example.pomodoroworkflow;

public class ShortBreak extends Task {
    String duration = "5";
    String description = "short break";

    ShortBreak() {
        super();
    }

    @Override
    public String getDuration() {
        return duration;
    }

    @Override
    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }
}
