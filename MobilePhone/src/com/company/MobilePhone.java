package com.company;

import java.util.ArrayList;

public class MobilePhone {

    private String myNumber;
    private ArrayList<Contact> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<Contact>();
    }

    public boolean addNewContact(Contact contact){
        if (findContact(contact.getName()) >= 0){
            System.out.println("Contact Exists");
            return false;
        }
        myContacts.add(contact);
        return true;
    }

    public boolean updateContact(Contact oldContact, Contact newContact){
        int oldContactIndex= findContact(oldContact);
        if (oldContactIndex >= 0){
            myContacts.remove(oldContactIndex);
            myContacts.add(oldContactIndex, newContact);
            return true;
        }
        return false;
    }

    public boolean removeContact(Contact contact){
        if (findContact(contact) >= 0){
            myContacts.remove(contact);
            return true;
        }
        return false;
    }

    private int findContact(Contact contact){

        return findContact(contact.getName());
    }

    private int findContact(String contactName){
        for (int i = 0; i < myContacts.size(); i++){
            if (myContacts.get(i).getName().equals(contactName)){
                return i;
            }
        }
        return -1;
    }

    public Contact queryContact(String contactName){
        int contactIndex = findContact(contactName);
        if (contactIndex >= 0) {
            return myContacts.get(contactIndex);
        }
        return null;
    }

    public void printContact(){
        for (Contact eachContact : this.myContacts){
            System.out.println(eachContact.getName());
        }
    }
}
