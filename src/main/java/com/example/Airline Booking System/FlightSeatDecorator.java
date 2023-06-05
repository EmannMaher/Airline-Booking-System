package com.example.project_oop;

public abstract class FlightSeatDecorator implements Seats {
    protected Seats flightSeat;

    public FlightSeatDecorator(Seats flightSeat) {

        this.flightSeat = flightSeat;
    }

    public abstract String getFacilities();

    public abstract Double getCost();
    //Seats mainCabinSeat = new WIFI(new SpecialMeal(new TV(new MainCabinSeat())));

}
