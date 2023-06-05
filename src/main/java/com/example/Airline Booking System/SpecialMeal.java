package com.example.project_oop;

public class SpecialMeal extends FlightSeatDecorator {
    public SpecialMeal(Seats flightSeat) {

        super(flightSeat);
    }

    @Override
    public String getFacilities() {

        return this.flightSeat.getFacilities() + "\nSpecialMeal";
    }

    @Override
    public Double getCost() {

        return this.flightSeat.getCost() + 500.0;
    }
}
