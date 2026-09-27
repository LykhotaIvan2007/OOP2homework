package com.nhlstenden.flightbooking.Flights;

import com.nhlstenden.flightbooking.Airports.Airport;
import com.nhlstenden.flightbooking.Planes.Plane;

import javax.lang.model.util.ElementScanner6;
import java.time.LocalDateTime;

public class Flight {
    private static final int JFK_AMS_DISTANCE = 5848;
    private static final int JFK_MEX_DISTANCE = 3366;
    private static final int JFK_LAX_DISTANCE = 3975;
    private static final int AMS_MEX_DISTANCE = 9206;
    private static final int AMS_LAX_DISTANCE = 8956;
    private static final int MEX_LAX_DISTANCE = 2500;
    private Airport departureAirport;
    private Airport arrivalAirport;
    private LocalDateTime departureDateAndTime;
    private FlightStatus status;
    private Plane plane;

    public Flight(Airport departureAirport, Airport arrivalAirport, LocalDateTime departureDateAndTime, Plane plane) {
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.departureDateAndTime = departureDateAndTime;
        this.status = FlightStatus.AWAITING_DEPARTURE;
        this.plane = plane;
    }

    public Airport getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(Airport departureAirport) {
        this.departureAirport = departureAirport;
    }

    public Airport getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(Airport arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public LocalDateTime getDepartureDateAndTime() {
        return departureDateAndTime;
    }

    public void setDepartureDateAndTime(LocalDateTime departureDateAndTime) {
        this.departureDateAndTime = departureDateAndTime;
    }

    public FlightStatus getStatus() {
        return status;
    }

    public void setStatus(FlightStatus status) {
        this.status = status;
    }

    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public double getDistance(){
        if ((this.departureAirport == Airport.JFK && this.arrivalAirport == Airport.AMS) || (this.departureAirport == Airport.AMS && this.arrivalAirport == Airport.JFK)){
            return JFK_AMS_DISTANCE;
        } else if ((this.departureAirport == Airport.JFK && this.arrivalAirport == Airport.MEX) || (this.departureAirport == Airport.MEX && this.arrivalAirport == Airport.JFK)) {
            return JFK_MEX_DISTANCE;
        } else if ((this.departureAirport == Airport.JFK && this.arrivalAirport == Airport.LAX) || (this.departureAirport == Airport.LAX && this.arrivalAirport == Airport.JFK)) {
            return JFK_LAX_DISTANCE;
        } else if ((this.departureAirport == Airport.AMS && this.arrivalAirport == Airport.MEX) || (this.departureAirport == Airport.MEX && this.arrivalAirport == Airport.AMS)) {
            return AMS_MEX_DISTANCE;
        } else if ((this.departureAirport == Airport.AMS && this.arrivalAirport == Airport.LAX) || (this.departureAirport == Airport.LAX && this.arrivalAirport == Airport.AMS)) {
            return AMS_LAX_DISTANCE;
        }else if ((this.departureAirport == Airport.MEX && this.arrivalAirport == Airport.LAX) || (this.departureAirport == Airport.LAX && this.arrivalAirport == Airport.MEX)){
            return MEX_LAX_DISTANCE;
        }else {
            throw new IllegalArgumentException("this destination does not exist");
        }
    }

    public void depart(){
        if (this.plane.getCurrentFuelLevel() >= this.plane.getConsumeFuelAmount(this.getDistance())){
            this.status = FlightStatus.DEPARTED;
        }else {
            throw new IllegalArgumentException("Not enough fuel to depart");
        }
    }

    public String sendInfoAboutFlight(){
        return this.departureAirport + " -> " + this.arrivalAirport + ". Departure" + this.departureDateAndTime;
    }
    public String sendInfoAboutPlane(){
        return this.plane.getCode() + ". " + this.plane.getCurrentFuelLevel() + " liter fuel. " + this.plane.getNumberOfEmptySeats() + " empty seats.";
    }
}
