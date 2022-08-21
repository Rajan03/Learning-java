package com.company;

public class Main {

    public static void main(String[] args) {
        leapYear(1990);
    }
    // If Else Statements

    // Program 1 = Leap Year
    public static void leapYear (int year) {
        if(year > 0){
            isLeapYear(year);
        }else{
            System.out.println("Year can't be Negative");
        }
    }
    private static void isLeapYear(int year) {
        if(year % 100 == 0) {
            centuryLeapYear(year);
        }else if(year % 4 == 0){
            System.out.println(year + " is a leap year.");
        }else{
            System.out.println(year + " is not a leap year.");
        }
    }
    private static void centuryLeapYear(int centuryyear) {
        if (centuryyear % 400 != 0) {
            System.out.println( centuryyear + " is a leap year.");
        }else{
            System.out.println(centuryyear + " is not a leap year.");
        }
    }
    //Leap Year Ends
}
