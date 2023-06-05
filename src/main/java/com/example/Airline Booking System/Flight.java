package com.example.project_oop;

public class Flight {
    String FlightId;
    String FlightName;
    String Source;
    String date;
    String Destination;
    String StartingTime;
    String ReachingTime;
    String Capacity;
    String Price;

    public Flight(String flightId, String flightName,  String date,String source,
                  String destination, String startingTime, String reachingTime, String capacity, String price) {
        FlightId = flightId;
        FlightName = flightName;
        Source = source;
        this.date = date;
        Destination = destination;
        StartingTime = startingTime;
        ReachingTime = reachingTime;
        Capacity = capacity;
        Price = price;
    }
}
