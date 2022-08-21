package com.company;

public class Manager extends Employee{

    // Fields
    private String department;

    // Constructor
    public Manager(long id, String name, String salary, String department) {
        super(id, name, salary);
        this.department = department;
    }
    // Method
    public void managerInfo(){
        System.out.println("\nManager of " + this.department);
        employeeDetail();
    }
}
