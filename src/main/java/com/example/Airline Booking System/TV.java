package com.example.project_oop;

public class TV extends FlightSeatDecorator {
    public TV(Seats flightSeat) {

        super(flightSeat);
    }

    @Override
    public String getFacilities() {

        return this.flightSeat.getFacilities() + "\nTV";
    }

    @Override
    public Double getCost() {

        return this.flightSeat.getCost() + 700.0;
    }
}
