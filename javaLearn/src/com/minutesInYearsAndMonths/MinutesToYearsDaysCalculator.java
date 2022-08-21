package com.minutesInYearsAndMonths;

public class MinutesToYearsDaysCalculator {

    public static void main(String[] args) {
        printYearsAndDays(525600); // → should print "525600 min = 1 y and 0 d"
        printYearsAndDays(1051200);// → should print "1051200 min = 2 y and 0 d"
        printYearsAndDays(561600); //→ should print "561600 min = 1 y and 25 d"
    }

    public static void printYearsAndDays(long minutes) {
        if (minutes < 0) {
            System.out.println("Invalid Values");
        } else {
            // minutes ko days mein cob=vert kiya
            long days = minutes / (60*24);
            // un days se kitne years bn re h ye calculate krliya
            long years = days/365;
            // years bnane k baad b agr kch din upr bn re h toh vo remainder mein aayege
            long remainingDaysAfterYears =  days % 365;
            //Example -
            // 561600 min h toh 561600/60*24 = 561600 min mein kitne din honge = 390 din
            // un 390 din mein kitne saal bn re h == 390/365 = 1.068 == 1 saal or kch din upr
            // vo jo kch upr din bn re h vo mereko days/365 k remainder mein milege ki kitne din upr bn re h = 25 din
            System.out.println(minutes + " min = " + years + " y and " + remainingDaysAfterYears + " d ");
        }
    }
}
//Write a method printYearsAndDays with parameter of type long named minutes.
//The method should not return anything (void) and it needs to calculate the years and days from the minutes parameter.
//If the parameter is less than 0, print text "Invalid Value".
//Otherwise, if the parameter is valid then it needs to print a message in the format "XX min = YY y and ZZ d"
//XX represents the original value minutes.
//YY represents the calculated years.
//ZZ represents the calculated days.
//EXAMPLES OF INPUT/OUTPUT:
//* printYearsAndDays(525600);  → should print "525600 min = 1 y and 0 d"
//* printYearsAndDays(1051200); → should print "1051200 min = 2 y and 0 d"
//* printYearsAndDays(561600);  → should print "561600 min = 1 y and 25 d"
//TIPS:
//* Be extra careful about spaces in the printed message.
//* Use the remainder operator
//* 1 hour = 60 minutes
//* 1 day = 24 hours
//* 1 year = 365 days
