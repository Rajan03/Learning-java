package com.company;

public class Person {

    // Fields
    private String firstName;
    private String lastName;
    private int age;


    // Getters
    public String getFirstName() {
        return this.firstName;
    }
    public String getLastName() {
        return this.lastName;
    }
    public int getAge() {
        return this.age;
    }


    // Setters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setAge(int age) {
        if (age < 0 || age > 100) {
            this.age = 0;
        }else{
            this.age = age;
        }

    }

    // Check if Teenager
    public boolean isTeen() {
        return this.age > 12 && this.age < 20;
    }

    // get Full name
    public String getFullName() {
        if (this.firstName.isEmpty() && this.lastName.isEmpty()) {
            return "";
        } else if (this.firstName.isEmpty()) {
            return this.lastName;
        } else if (this.lastName.isEmpty()){
            return this.firstName;
        }else{
           return firstName + " " + lastName;
        }
    }
}
