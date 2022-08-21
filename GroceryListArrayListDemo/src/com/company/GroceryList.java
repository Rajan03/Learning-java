package com.company;

import java.util.ArrayList;

public class GroceryList {

    private ArrayList<String> groceryList = new ArrayList<String>();

    public void addItem(String item){
        groceryList.add(item);
    }
    public void printList(){
        System.out.println("No. of List Items are: " + groceryList.size() + "\r Items are: ");
        for (int i = 0; i < groceryList.size(); i++){
            System.out.println(i+1 + ". " + groceryList.get(i));
        }
    }
    public int findItem(String item){
        return groceryList.indexOf(item);
    }
    public String modifyItem(String replacing, String replaceWith){
        int itemPosition = findItem(replacing);
        return groceryList.set(itemPosition, replaceWith);
    }
    public void removeItem(String itemName){
        int itemNum = findItem(itemName);
        groceryList.remove(itemNum);
    }

}
