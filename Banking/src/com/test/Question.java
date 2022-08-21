package com.test;

import java.math.BigInteger;
import java.util.ArrayList;

public class Question {

    public static void main(String[] args) {
        int n = 3;
        int[] array = new int[]{1, 0, -2};
        int length = subsequencesLength(n, array);
        System.out.println(length);
    }

    static int subsequencesLength(int n, int[] arr) {
        int numOfSubSeq = (int) Math.pow(2, n);
        ArrayList<ArrayList<Integer>> arrOfSubArr = new ArrayList<ArrayList<Integer>>();

        for (int i = 1; i < numOfSubSeq; i++) {
            ArrayList<Integer> subArr = new ArrayList<Integer>();
            int min = 0;
            int max = 0;

            // Creating subsequence
            for (int j = 0; j < n; j++) {
                if (BigInteger.valueOf(i).testBit(j)) {
                    subArr.add(arr[j]);
                }
            }

            // Get min and max
            for (int k = 0; k < subArr.size(); k++) {
                min = subArr.get(k);
                max = subArr.get(k);

                System.out.println(min + " AND " + max);

                for (int l = k + 1; l < subArr.size(); l++) {
                    if (subArr.get(l) < min) {
                        min = subArr.get(l);
                    }
                    if (max < subArr.get(l)) {
                        max = subArr.get(l);
                    }
                }
            }
            if (min * max == 0) {
                arrOfSubArr.add(subArr);
            }
        }
        return arrOfSubArr.size();
    }
}
