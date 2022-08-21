package com.company;

// You have to represent a point in 2D space. Write a class with the name Point.
// The class needs two fields (instance variables) with name x and y of type int.
//
//     The class needs to have two constructors.
//     The first constructor does not have any parameters (no-arg constructor).
//     The second constructor has parameters x and y of type int and it needs to initialize the fields.
//
//     Write the following methods (instance methods):
//     * Method named getX without any parameters, it needs to return the value of x field.
//
//     * Method named getY without any parameters, it needs to return the value of y field.
//
//     * Method named setX with one parameter of type int, it needs to set the value of the x field.
//
//     * Method named setY with one parameter of type int, it needs to set the value of the y field.
//
//     * Method named distance without any parameters, it needs to return the distance between this
//     Point and Point 0,0 as double.
//
//     * Method named distance with two parameters x, y both of type int, it needs to return the
//     distance between this Point and Point x,y as double.
//
//     * Method named distance with parameter another of type Point, it needs to return the distance
//     between this Point and another Point as double.


public class Point {

    // Fields
    private int x;
    private int y;

    // Passing Parameter to class
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    // With No Parameter
    public Point() {
        this.x = 0;
        this.y = 0;
    }

    // Getters And Setters
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }


    // Distance
    public double distance(){
        double distance = 0;

        distance = Math.sqrt((this.x)*(this.x) + (this.y)*(this.y));

        return distance;
    }
    public double distance(Point sec){
        double distance = 0;

        distance = Math.sqrt((sec.x - this.x)*(sec.x - this.x) + (sec.y - this.y)*(sec.y - this.y));

        return distance;
    }
    public double distance(int x, int y){
        double distance = 0;

        distance = Math.sqrt((x - this.x)*(x - this.x) + (y - this.y)*(y - this.y));

        return distance;
    }
}
