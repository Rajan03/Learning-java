package com.company;

public class Main {

    public static void main(String[] args) {
        BankAccount myAccount = new BankAccount();

        // Setting Account
            myAccount.setAccountNumber(225477332);
            myAccount.setBalance(0);
            myAccount.setCustomerName("Rajan");
            myAccount.setEmail("rajan@gmail.com");
            myAccount.setPhoneNumber(987653321);

        // Getting Account
        System.out.println("Customer Name: " + myAccount.getCustomerName());
        System.out.println("Account Number: " + myAccount.getAccountNumber());
        System.out.println("Available Balance: " + myAccount.getBalance());

        // Increment Balance
        myAccount.amountAdded(60000);
        System.out.println("Total Available Balance: " + myAccount.getBalance());

        // Decrement Balance
        myAccount.deductAmount(20000);
        System.out.println("Remaining Balance: " + myAccount.getBalance());

        // Increment Balance
        myAccount.amountAdded(20000);
        System.out.println("Total Available Balance: " + myAccount.getBalance());

        // Decrement Balance
        myAccount.deductAmount(60000);
        System.out.println("Remaining Balance: " + myAccount.getBalance());

    }
}
