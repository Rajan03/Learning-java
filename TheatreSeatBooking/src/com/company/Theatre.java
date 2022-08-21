package com.company;

import java.util.*;

public class Theatre {
    private final String theatreName;
    private final List<Seat> seats= new ArrayList<Seat>();

    public Theatre(String theatreName, int rows, int seatsPerRow) {
        this.theatreName = theatreName;

        int lastRow = 'A' + (rows-1);
        for (char row = 'A'; row <= lastRow; row++){
            for (int seatNumber = 1; seatNumber <= seatsPerRow; seatNumber++){
                Seat seat = new Seat(row + String.valueOf(seatNumber));
                seats.add(seat);
            }
        }
    }

    public void getSeats() {
        for (Seat eachSeat : seats){
            System.out.println(eachSeat.getSeatNumber());
        }
    }

    public String getTheatreName() {
        return theatreName;
    }
    public boolean reserveSeat(String seatNum){
        Seat requestedSeat = new Seat(seatNum);
        int findSeat = Collections.binarySearch(seats, requestedSeat, null);
        if (findSeat >= 0){
            return seats.get(findSeat).reserve();
        }else {
            System.out.println("No Such Seat Found");
            return false;
        }
    }

    private static class Seat implements Comparable<Seat>{

        private final String seatNumber;
        private boolean reserved;

        public Seat(String seatNumber) {
            this.seatNumber = seatNumber;
        }

        @Override
        public int compareTo(Seat seat) {
            return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
        }

        public String getSeatNumber() {
            return seatNumber;
        }
        public boolean reserve(){
            if (!reserved){
                this.reserved = true;
                System.out.println("Booking " +seatNumber + " for you...");
                return true;
            }else {
                return false;
            }
        }
        public boolean cancel(){
            if (reserved){
                this.reserved = false;
                System.out.println("Seat Reservation cancelled");
                return true;
            }else {
                return false;
            }
        }
    }
}


