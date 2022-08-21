package com.test;


import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String input = "15,3,1,70,53,71";
        String output = "";
        ArrayList<Integer> armstrongNumberArr = new ArrayList<Integer>();

        String[] inputArray = input.split(",");

        for (int i = 0; i < inputArray.length; i++) {
            for (int j = i + 1; j < inputArray.length; j++) {
                int num = Integer.parseInt(inputArray[i] + inputArray[j]);

                if (isArmstrong(num)) {
                    armstrongNumberArr.add(num);
                }
            }
        }

        if (armstrongNumberArr.size() > 0) {
            for (int num : armstrongNumberArr) {
                output = output.concat(String.valueOf(num));
            }
        } else {
            output = "-1";
        }
        System.out.println(output);
    }

    private static boolean isArmstrong(int x) {
        int n = order(x);
        int temp = x, sum = 0;
        while (temp != 0) {
            int r = temp % 10;
            sum = sum + power(r, n);
            temp = temp / 10;
        }
        return sum == x;
    }

    private static int order(int x) {
        int n = 0;
        while (x != 0) {
            n++;
            x = x / 10;
        }
        return x;
    }

    private static int power(int x, long y) {
        if (y == 0) {
            return 1;
        }
        if (y % 2 == 0) {
            return power(x, y / 2) * power(x, y / 2);
        }
        return x * power(x, y / 2) * power(x, y / 2);
    }
}
