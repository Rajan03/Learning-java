package com.company;

public class Cuboid extends Rectangle{

//    Fields
    private double height;

//    Constructor
    public Cuboid(double length, double width, double height) {
        super(length, width);
        this.height = height < 0 ? 0 : height;
    }

    //    Getter
    public double getHeight() {
        return height;
    }

//    Methods
    public double getVolume() {
        return getArea() * this.height;
    }
}
