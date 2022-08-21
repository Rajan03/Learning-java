package com.company;

public class Main {

    public static void main(String[] args) {

        MobilePhone newMobile = new MobilePhone("1233456");
        Contact newContact = Contact.createContact("Rajan", "123243567658");
        Contact newContactTwo = Contact.createContact("twst", "2345432");
        Contact newContactThree = Contact.createContact("test", "098765432");
        Contact newContactFour = Contact.createContact("jai", "234567");
        Contact newContactFive = Contact.createContact("raj", "24567");
        Contact newContactSix = Contact.createContact("sjv", "76543");
        Contact newContactSeven = Contact.createContact("snjay", "123243567658");

        newMobile.addNewContact(newContact);
        newMobile.addNewContact(newContactTwo);
        newMobile.addNewContact(newContactThree);
        newMobile.addNewContact(newContactFour);
        newMobile.addNewContact(newContactFive);
        newMobile.addNewContact(newContactSix);
        newMobile.addNewContact(newContactSeven);
        newMobile.removeContact(newContactSeven);

        newMobile.printContact();
        System.out.println(newMobile.queryContact("raj").getPhoneNumber());
    }
}
