package com.company;

public class Main {
    int num = 3; // global scope - fields --- class

    public static long toMilesPerHour(double kilometersPerHour) {
        long result = 0; // scope
        if (kilometersPerHour > 0) {
            result = Math.round(kilometersPerHour / 1.60934);
            int r =0;//
            return result;
        } else {
            return -1;
        }
    }

    public static boolean shouldWakeUp(boolean barking, int hourOfDay) {
        if (hourOfDay < 0 || hourOfDay > 23) {
            return false;
        } else {
            if (hourOfDay < 8 || hourOfDay > 22) {
                return barking;
            } else {
                return false;
            }
        }
    }
}
