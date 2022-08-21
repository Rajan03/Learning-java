package com.company;

public class Player {

    private String name;
    private int health;
    private String weapon;

    public int getHealth() {
        return health;
    }

    public Player(String name, int health, String weapon) {
        this.name = name;
        this.health = (health > 0 && health < 100) ? health : 0;
        this.weapon = weapon;
    }

    public int looseHealth(int damage){
        if (this.health <= 0){
            System.out.println("Player Knocked Out");
            return-1;
        }else{
            return this.health -= damage;
        }
    }
}
