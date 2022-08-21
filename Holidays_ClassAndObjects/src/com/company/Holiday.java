package com.company;

import java.util.Date;

public class Holiday {

    // Fields
    private String name;
    private int day;
    private String month;

    // Constructors

    // Default
    public Holiday(){
    this("Normal Day", 11, "July");
    }

    // Three Arguments
    public Holiday(String name, int day, String month) {
        this.name = name;
        this.day = day;
        this.month = month;
    }

    // Getter and Setter

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    // Methods
    public boolean inSameMonth(Holiday day){
        System.out.println(day.name + " in " + day.month);
        return this.month == day.month;
    }
}
