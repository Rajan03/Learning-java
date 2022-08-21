package com.company;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static GroceryList groceryList = new GroceryList();

    public static void main(String[] args) {
        boolean end = false;
        int position = 0;
        availableOptions();
        while (!end){
            System.out.println("Enter Choice: ");
            position = scanner.nextInt();
            scanner.nextLine();
            switch (position){
                case 0:
                    availableOptions();
                    break;
                case 1:
                    groceryList.printList();
                    break;
                case 2:
                    addNewItem();
                    break;
                case 3:
                    removeItemInList();
                    break;
                case 4:
                    modifyItemInList();
                    System.out.println("Item updated");
                    break;
                case 5:
                    searchFroItem();
                    break;
                case 6:
                    end = true;
                    break;
            }
        }

    }
    public static void availableOptions(){
        System.out.println("0. Shows Available Options");
        System.out.println("1. Print List");
        System.out.println("2. Add New Item");
        System.out.println("3. Remove Item");
        System.out.println("4. Modify Existing Item");
        System.out.println("5. Search For Item");
        System.out.println("6. Close Application");

    }
    public static void addNewItem() {
        System.out.println("Enter New Item: ");
        groceryList.addItem(scanner.nextLine());
    }
    public static String modifyItemInList(){
        System.out.println("Item you want to replace: ");
        String replacing = scanner.nextLine();
        System.out.println("Enter New Item to Replace " + replacing + ": ");
        String replaceWith = scanner.nextLine();
        return groceryList.modifyItem(replacing, replaceWith);
    }
    public static void removeItemInList(){
        System.out.println("Item you want to remove: ");
        groceryList.removeItem(scanner.nextLine());
    }
    public static void searchFroItem(){
        System.out.println("Enter Item to be Searched: ");
        String itemName = scanner.nextLine();
        int itemNum = groceryList.findItem(itemName);
        if (itemNum >= 0){
            System.out.println(itemName + " Found");
        }else{
            System.out.println(itemName + " doesn't Exists");
        }
    }
}
