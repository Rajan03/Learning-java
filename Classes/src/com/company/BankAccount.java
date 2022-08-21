// Task :
// Create a new class for bank account
// Create fields for account number, balance, customer name, email and phone number
// Create getters and setters for each fields.
// Create two additional methods
// 1. To allow customer to deposit fund. (increase balance)
// 2. To allow customer to withdraw fund. (decrease balance)
// Withdrawal should be allowed only if sufficient balance available

// Test Cases:
//

package com.company;

public class BankAccount {

    private long accountNumber;
    private double balance;
    private String customerName;
    private String email;
    private long phoneNumber;

    // Default
    public BankAccount(){
        this.accountNumber = 0 ;
        this.balance = 0;
        this.customerName= "Default";
        this.email = "Default" ;
        this.phoneNumber = 0;

    }

    // Setters
    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // Getters
    public long getAccountNumber() {
        return this.accountNumber;
    }
    public double getBalance() {
        return this.balance;
    }
    public String getCustomerName() {
        return this.customerName;
    }
    public String getEmail() {
        return this.email;
    }
    public long getPhoneNumber() {
        return this.phoneNumber;
    }

    // Incrementing Balance
    public double amountAdded( double amount){
        if (amount >= 0){
            System.out.println("\nAmount Deposited Successfully \nAmount added: " + amount);
            this.balance += amount;
            return this.balance;
        }
        return -1;
    }

    // Withdrawing Amount
    public double deductAmount(double amount){
        if (amount >= 0 && amount <= this.balance) {
            System.out.println("\nAmount Withdrawn Successfully \n Withdrawn Amount:" + amount);
            this.balance -= amount;
            return this.balance;
        }else{
            System.out.println("\nInsufficient Balance or Invalid Amount Entered");
            return -1;
        }
    }
}
