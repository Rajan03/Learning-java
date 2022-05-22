package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Map<Integer, Location> locations = new HashMap<Integer, Location>();

    public static void main(String[] args) {

	    Scanner scanner = new Scanner(System.in);

        locations.put(0, new Location(0, "You are Out of the Game"));
        locations.put(1, new Location(1, "You are in the North"));
        locations.put(2, new Location(2, "You are in the South"));
        locations.put(3, new Location(3, "You are in the West"));
        locations.put(4, new Location(4, "You are East"));
        locations.put(5, new Location(5, "You are Lost"));

        // number of exits on each entry
        locations.get(1).addExit("W", 3);
        locations.get(1).addExit("E", 4);
        locations.get(1).addExit("S", 2);
        locations.get(1).addExit("L", 5);
        locations.get(2).addExit("L", 5);
        locations.get(3).addExit("N", 1);
        locations.get(4).addExit("N", 1);
        locations.get(4).addExit("S", 2);
        locations.get(5).addExit("N", 1);
        locations.get(5).addExit("S", 2);

        Map<String, String> vocabulary = new HashMap<String, String>();
    }
}
