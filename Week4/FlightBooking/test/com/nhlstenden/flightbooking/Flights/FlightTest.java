package com.nhlstenden.flightbooking.Flights;

import com.nhlstenden.flightbooking.Airports.Airport;
import com.nhlstenden.flightbooking.Planes.Plane;
import com.nhlstenden.flightbooking.Planes.PrivatePlane;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class FlightTest {

    @Test
    void getDistanceThrowsException() {
        Plane plane = new PrivatePlane("zxc1000-7", 1000000, 50);
        Flight flight = new Flight(Airport.JFK, Airport.JFK, LocalDateTime.now(), plane);
        assertThrows(IllegalArgumentException.class, ()-> flight.getDistance());
    }

    @Test
    void departThrowsException() {
        Plane plane = new PrivatePlane("zxc1000-7", 0, 10);
        Flight flight = new Flight(Airport.JFK, Airport.AMS, LocalDateTime.now(), plane);
        assertThrows(IllegalArgumentException.class, ()-> flight.depart());
    }
}