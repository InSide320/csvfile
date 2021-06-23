package com.company;

public class Users {
    private String name_surname;
    private String date;
    private String work_hour;
    public Users (String name_surname, String date, String work_hour){
        this.name_surname = name_surname;
        this.date = date;
        this.work_hour = work_hour;
    }
    public void setDate(String date) {
        this.date = date;
    }

    public void setName_surname(String name_surname) {
        this.name_surname = name_surname;
    }

    public void setWork_hour(String work_hour) {
        this.work_hour = work_hour;
    }

    public String getDate() {
        return date;
    }

    public String getWork_hour() {
        return work_hour;
    }

    public String getName_surname() {
        return name_surname;
    }
}
