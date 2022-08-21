package com.company;

public class Main {

    public static void main(String[] args) {

      calculator(12.7, 12.5 ,"Multiply");
    }
    // Switch


    // Program - 1  Calculator

    public static void calculator(double num1, double num2, String operation){
        switch (operation){
            case "Add":
                System.out.println(num1 + num2);
                break;
            case "Subtract":
                System.out.println(num1 - num2);
                break;
            case "Multiply":
                System.out.println(num1 * num2);
                break;
            case "Divide":
                System.out.println(num1 / num2);
                break;
            default:
                System.out.println(operation + " not Available \n" +
                        "Note : Available Operations " +
                        "\n Add, Subtract, Divide, Multiply");
        }
    }
    // Calculator Ends
}
