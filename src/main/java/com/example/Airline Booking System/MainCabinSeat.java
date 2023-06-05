package com.example.project_oop;

public class MainCabinSeat implements Seats {
    Double price;
    public MainCabinSeat(Double price){
        this.price =price;
    }
    @Override
    public String getFacilities() {
        return "Main Cabin Seat";
    }

    @Override
    public Double getCost() {
        return 2000.0+price;
    }
}
