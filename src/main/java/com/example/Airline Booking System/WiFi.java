package com.example.project_oop;
public class WiFi extends FlightSeatDecorator {
    public WiFi(Seats flightSeat) {

        super(flightSeat);
    }

    @Override
    public String getFacilities() {

        return this.flightSeat.getFacilities() + "\nWiFi";
    }

    @Override
    public Double getCost() {

        return this.flightSeat.getCost() + 1000.0;
    }
}
