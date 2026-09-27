package com.nhlstenden.flightbooking.Bookings;

import com.nhlstenden.flightbooking.Airports.Airport;
import com.nhlstenden.flightbooking.Flights.Flight;
import com.nhlstenden.flightbooking.Luggages.Luggage;
import com.nhlstenden.flightbooking.Planes.Plane;
import com.nhlstenden.flightbooking.Planes.PrivatePlane;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookingTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void isLuggageContainsOnlyOneCarryBaggageThrowsException() {
        assertThrows(IllegalArgumentException.class, ()-> {
            Booking booking = new Booking();
            List<Luggage> luggages = new ArrayList<>(List.of(new Luggage(10, false), new Luggage(15, false)));
            booking.isLuggageContainsOnlyOneCarryBaggage(luggages);
        });
    }

    @Test
    void bookFlight() {
        Plane plane = new PrivatePlane("zxc1000-7", 1000000, 50);
        Flight flight = new Flight(Airport.JFK, Airport.AMS, LocalDateTime.now(), plane);
        Booking booking = new Booking();
        booking.addFlight(flight);
        booking.bookFlight("Ivan", Airport.JFK, Airport.AMS, null);
        assertEquals(49, flight.getPlane().getNumberOfEmptySeats());
    }
}