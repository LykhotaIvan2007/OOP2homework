package com.nhlstenden.flightbooking.Bookings;

import com.nhlstenden.flightbooking.Airports.Airport;
import com.nhlstenden.flightbooking.Flights.Flight;
import com.nhlstenden.flightbooking.Flights.FlightStatus;
import com.nhlstenden.flightbooking.Luggages.Luggage;

import java.util.ArrayList;
import java.util.List;

public class Booking {
    private List<Flight> flights;

    public Booking() {
        this.flights = new ArrayList<>();
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void addFlight(Flight flight){
        this.flights.add(flight);
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    public void bookFlight(String name, Airport departureAirport, Airport arrivalAirport, List<Luggage> luggages){
        if (name == null || name.isBlank()){
            throw new IllegalArgumentException("name can not be null or empty");
        }
        if (departureAirport == null){
            throw new IllegalArgumentException("departure airport can not be null");
        }
        if (arrivalAirport == null){
            throw new IllegalArgumentException("arrival airport can not be null");
        }
        for (Flight flight: this.flights){
            if (flight.getArrivalAirport().equals(arrivalAirport) && flight.getDepartureAirport().equals(departureAirport) &&
            flight.getStatus() != FlightStatus.DEPARTED && this.isLuggageContainsOnlyOneCarryBaggage(luggages)){
                flight.getPlane().reserveSeat(name);
            }
        }
    }

    public boolean isLuggageContainsOnlyOneCarryBaggage(List<Luggage> luggages){
        if (luggages == null){
            return true;
        }
        int counter = 0;
        for (Luggage luggage: luggages){
            if (!luggage.isHold()){
                counter++;
            }
        }
        if (counter > 1){
            throw new IllegalArgumentException("You can have only 1 carry baggage");
        }

        return true;
    }
}
