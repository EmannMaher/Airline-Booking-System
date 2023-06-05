package com.example.project_oop;

public class EconomySeat implements Seats {
    Double price;
    public  EconomySeat (Double price){
        this.price=price;
    }
    @Override
    public String getFacilities() {
        return "Economy Seat";
    }

    @Override
    public Double getCost() {
        return price;
    }
}
