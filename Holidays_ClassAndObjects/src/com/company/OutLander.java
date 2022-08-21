package com.company;

public class OutLander extends Car{

    private String info;

    public OutLander( String brand, int gear, String info) {
        super("OutLander", brand, gear);
        this.info = info;
    }
    public void outLanderDetails(){
        setGear();
        System.out.println(this.info);
    }
}
