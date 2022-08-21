package com.company;

public class Main {

    public static void main(String[] args) {

        int number = 1441;
        System.out.println("Test For " + number);

        // Palindrome
        boolean output = isPalindrome(number);
        System.out.println("Palindrome : " + output);

        // First and Last Digit Sum
        int sumOutput = sumFirstAndLastDigit(number);
        System.out.println("Sum of First and Last Digit Of " + number + " is " + sumOutput);
    }

    // While Loop

    // Program - 1  Palindrome
    public static boolean isPalindrome(int number) {
        int reverse = 0;
        int actualNum = number;

        while(number != 0){
            int remainder = number % 10;
            reverse = (reverse * 10) + remainder;
            number = number / 10;
        }
        return reverse == actualNum;
    }
    // Palindrome Ends



    // Program - 2 First and Last Digit Sum
    public static int sumFirstAndLastDigit(int number) {
        if (number > 0){
            int fstNmbr = firstNumber(number);
            int lstNmbr = lastNumber(number);
            return fstNmbr + lstNmbr;
        }else{
            return -1;
        }
    }
    private static int firstNumber(int num){
        while (num >= 10){
            num /= 10;
        }
        return num;
    }
    private static int lastNumber(int num){
        while (num >= 10){
            num %= 10;
        }
        return num;
    }
    // First and last Digit Sum ends
}
