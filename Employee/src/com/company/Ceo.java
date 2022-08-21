package com.company;

public class Ceo extends Employee{

    // Feild
    private String position;

    // Constructor

    public Ceo(long id, String name, String salary, String position) {
        super(id, name, salary);
        this.position = position;
    }

    // method
    public void ceoInfo(){
        System.out.println(this.position);
        employeeDetail();
    }
}
