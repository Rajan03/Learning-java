package com.company;

public class Duck {

    private String name;
    private  String type;
    private int distanceTraveled;

    public String getType() {
        return type;
    }

    public Duck(String name){

        this.name = name;
    }

    public void fly(){
        System.out.println("flying");
    }
}
