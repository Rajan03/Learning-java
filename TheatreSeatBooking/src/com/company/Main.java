package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // 1
        Theatre theatre = new Theatre("OHM", 8, 12);

//        theatre.getSeats();
//        if (theatre.reserveSeat("H11")){
//            System.out.println("Hey! Your Seat is Booked");
//        } else {
//            System.out.println("Seat Already Booked");
//        }
//        System.out.println("=============================================");
//
//        if (theatre.reserveSeat("H11")){
//            System.out.println("Hey! Your Seat is Booked");
//        } else {
//            System.out.println("Seat Already Booked!");
//        }

        // 2
        Theatre theatreTwo = new Theatre("VR Mall PVR", 13, 15);

        if (theatre.reserveSeat("G12")){
            System.out.println("Hey! Your Seat is Booked");
        } else {
            System.out.println("Seat Already Booked");
        }
        System.out.println("=============================================");

        if (theatre.reserveSeat("G12")){
            System.out.println("Hey! Your Seat is Booked");
        } else {
            System.out.println("Seat Already Booked!");
        }


    }
}
