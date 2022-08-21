package com.company;

public class Main {

    public static void main(String[] args) {

        // instantiating CEO class
        Ceo head = new Ceo(1L, "Tim Balchuka", "30,000,00", "Owner of the company.");
        head.ceoInfo();

        //instantiating Managers
        Manager itManager = new Manager(2, "Brad Traversy", "5,000,00", "Information Technology");
        itManager.managerInfo();

        Manager marketingManager = new Manager(3, "Tim Corey", "3,000,00", "Marketing and Sales");
        marketingManager.managerInfo();

        // instantiating Employees
        Employee employee = new Employee(101,"Mark", "40,000");
        Employee employee1 = new Employee(102, "Zoey", "30,000");
        employee.employeeDetail();
        employee1.employeeDetail();
    }
}
