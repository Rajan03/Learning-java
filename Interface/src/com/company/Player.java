package com.company;

import java.util.ArrayList;
import java.util.List;

public class Player implements ISaveable {

    private String name;
    private String weapon;
    private int hitPoints;
    private int strength;

    public Player(String name, int hitPoints, int strength) {
        this.name = name;
        this.weapon = "Sword";
        this.hitPoints = hitPoints;
        this.strength = strength;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public List<String> write() {
        List<String> playersData = new ArrayList<String>();
        String eachPlayer = toString();
        playersData.add(eachPlayer);
        return playersData;
    }

    @Override
    public void read(List<String> data) {
        
    }

    @Override
    public String toString() {
        return "Player{ name=" +" '"+
                this.name + "', "+ "hitPoints: " +" '"+
                this.hitPoints + "', "+ "Strength: " +" '"+
                this.strength + "', "+ "Weapon: " +" '"+
                this.weapon + "'}";
    }
}
