package com.example.pomodoroworkflow;

public class LongBreak extends Task {
    String duration = "30";
    String description = "long break";

    LongBreak() {
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
