package com.company;

public class Vehicle {

    private String name;
    private String brand;
    private int speed;
    private String direction;


    public Vehicle(String name, String brand) {
        this.name = name;
        this.brand = brand;
        this.speed = 1;
        this.direction = "Rest";
    }

    public void moving(int gear) {
        this.speed += 2 * (gear * gear);
        this.direction = gear >= 3 ? "North" : "West" ;
        System.out.println(this.name + " is moving at speed " + this.speed + " in direction " + this.direction);
    }
}
