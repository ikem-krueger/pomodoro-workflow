package com.example.pomodoroworkflow;

public class Mitglied {

    private String name, vorname, wohnort;

    public Mitglied(String name, String vorname, String wohnort) {
        this.name = name;
        this.vorname = vorname;
        this.wohnort = wohnort;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getWohnort() {
        return wohnort;
    }

    public void setWohnort(String wohnort) {
        this.wohnort = wohnort;
    }
}
