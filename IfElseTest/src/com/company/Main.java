package com.company;

public class Main {

    public static void main(String[] args) {
        int number1 = 13;
        int number2 = 35;
        System.out.println(number1 + " and " + number2 );

    // Shared Digit Test
        boolean check = hasSharedDigit( number1, number2);
        System.out.println("Shared Digit? " + check);
    }


    // Program 1 - Shared Digit
    public static boolean hasSharedDigit(int number1, int number2){
        int tenthPlaceNum1 = 0;
        int tenthPlaceNum2 = 0;
        int firstPlaceNum1 = 0;
        int firstPlaceNum2 = 0;

        if(ifTwoDigitNumber(number1, number2)){

            tenthPlaceNum1 = number1/10;
            tenthPlaceNum2 = number2/10;
            firstPlaceNum1 = number1%10;
            firstPlaceNum2 = number2%10;
            return tenthPlaceNum1 == tenthPlaceNum2 || firstPlaceNum1 == firstPlaceNum2 || tenthPlaceNum1 == firstPlaceNum2 || firstPlaceNum1 == tenthPlaceNum2;
        }else{
            return false;
        }
    }
    private static boolean ifTwoDigitNumber(int number1, int number2){
        return 10 <= number1 && number1 <= 99 && 10 <= number2 && number2 <= 99;
    }
    // Shared Digit Ends

}