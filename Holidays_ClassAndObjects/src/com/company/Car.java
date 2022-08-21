package com.company;

public class Car extends Vehicle{

    private int gear;

    public Car(String name, String brand, int gear) {
        super(name, brand);
        this.gear = gear;
    }

    public void setGear(){
        moving(this.gear);
        System.out.println("The vehicle is gearing at " + this.gear );

    }
}
