package com.company;

public class DeluxeBurger extends Hamburger{

    public DeluxeBurger() {
        super("Deluxe Burger", "Sausage and Bacon", 14.40, "White");
        super.addHamburgerAddition1("Chips", 1.10);
        super.addHamburgerAddition2("Cold Drink", 3.60);
    }

    @Override
    public void addHamburgerAddition1(String name, double price) {
        System.out.println("Couldn't add " + name + " No more items can be added to Deluxe Burger");
    }

    @Override
    public void addHamburgerAddition2(String name, double price) {
        addHamburgerAddition1(name, price);
    }

    @Override
    public void addHamburgerAddition3(String name, double price) {
        addHamburgerAddition1(name, price);
    }

    @Override
    public void addHamburgerAddition4(String name, double price) {
        addHamburgerAddition1(name, price);
    }
}
