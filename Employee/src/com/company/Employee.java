package com.company;

public class Employee {

    // fields
    public long id;
    private String name;
    private String salary;
    private String designation;
    

    // constructor
    public Employee(long id, String name, String salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.designation = "Employee";
    }

    // Method
    public void employeeDetail(){
        System.out.println("\n" + this.designation + ", id : " + this.id +
                ", Name : " + this.name +
                ", and Salary : " + this.salary);
    }
}
