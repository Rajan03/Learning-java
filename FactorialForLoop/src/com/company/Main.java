package com.company;

public class Main {

    public static final int TWO_DIGIT = 10;

    public static void main(String[] args) {
	    int number1 = 12;
	    int number2 = 96;

	    // Factorial Test
        long output1 = factorial(number1);
        System.out.println("Factorial Of " + number1 +" is " + output1);

        // Sum Of Odd Test
        int output2 = sumOdd(number1, number2);
        System.out.println("Sum Of Odd Numbers in between " + number1 + " and " + number2 + " is " + output2);

        // Greatest Common Divisor Test
        int checkResult = getGreatestCommonDivisor( number1, number2);
        System.out.println("Greatest Common Factor Between " + number1 + " and " + number2 + " is " + checkResult);

        // Continue Example
        skipDiagonalElementsInMatrix(6);

    }
    // For Loop

    // Program - 1 Factorial
    public static long factorial(int number) {
        long result = 1;
        if (number > 0) {
            for (int i = 1; i <= number; i++) {
                result *= i;
            }
            return result;
        }else {
            return -1;
        }
    }
    // Factorial Ends


    // Program - 2 Sum of Odd Numbers
    public static boolean isOdd(int number) {
        if(number > 0) {
            return number % 2 != 0;
        }else{
            return false;
        }
    }
    public static int sumOdd(int numStart, int numEnd) {
        int oddSum = 0;

        if (numStart <= numEnd && numStart > 0){
            for (int i = numStart; i <= numEnd; i++){
                if (isOdd(i)){
                    oddSum += i;
                }
            }
        }else{
            return -1;
        }

        return oddSum;
    }
    // Sum Odd Ends


    
    // Program - 3  Greatest Common Divisor
    public static int getGreatestCommonDivisor(int firstNumber, int secondNumber){
        if(firstNumber < TWO_DIGIT || secondNumber < TWO_DIGIT){
            return -1;
        }else{
            int commonFactor = 0;

            commonFactor = getCommonFactor(firstNumber, secondNumber, commonFactor);
            return commonFactor;
        }
    }

    private static int getCommonFactor(int firstNumber, int secondNumber, int commonFactor) {
        for (int i = 1; i <= firstNumber; i++){
            if (firstNumber % i == 0 && secondNumber % i == 0){
                commonFactor = i;
            }
        }
        return commonFactor;
    }
    // Greatest Common Divisor Ends


    // Program - 4 Continue Statement
    public static void skipDiagonalElementsInMatrix(int matrixSize) {
        for (int i = 1; i < matrixSize; i++) {
            for (int j = 1; j < matrixSize; j++ ) {
                if (i==j) {
                    continue;
                }
                System.out.println(i + " " + j);
            }
        }
    }
}
