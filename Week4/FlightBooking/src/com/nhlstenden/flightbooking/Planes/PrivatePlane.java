package com.nhlstenden.flightbooking.Planes;

import com.nhlstenden.flightbooking.Luggages.Luggage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrivatePlane extends Plane {
    private static final double AMOUNT_OF_SEATS_MULTIPLICATION_NUMBER = 1.31;
    private static final double SEATS_TAKEN_MULTIPLICATION_NUMBER = 1.87;
    private static final double WEIGHTS_OF_LUGGAGE_MULTIPLICATION_NUMBER = 0.4;
    private int numberOfSeats;
    private Map<Integer, String> nameSeatNumber;

    public PrivatePlane(String code, double currentFuelLevel, int numberOfSeats) {
        super(code, currentFuelLevel);
        this.numberOfSeats = numberOfSeats;
        nameSeatNumber = new HashMap<>();
    }

    public PrivatePlane() {

    }

    @Override
    public void addLuggage(Luggage luggage) {
        if (luggage.isHold()){
            throw new RuntimeException("In private Plane You can not keep hold luggage");
        }
        super.addLuggage(luggage);
    }

    @Override
    public double getConsumeFuelAmount(double distanceOfFlight) {
        return this.numberOfSeats * AMOUNT_OF_SEATS_MULTIPLICATION_NUMBER *
                distanceOfFlight +
                (this.nameSeatNumber.size() * SEATS_TAKEN_MULTIPLICATION_NUMBER) +
                (super.getWeightOfLuggage() * WEIGHTS_OF_LUGGAGE_MULTIPLICATION_NUMBER);
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    @Override
    public void reserveSeat(String name){
        if (name == null || name.isBlank()){
            throw new IllegalArgumentException("name can not be null or empty");
        }
        if (this.numberOfSeats < this.nameSeatNumber.size() + 1){
            throw new RuntimeException("all seats are taken");
        }
        this.nameSeatNumber.put(this.nameSeatNumber.size() + 1, name);
    }

    @Override
    public int getNumberOfEmptySeats() {
        return this.numberOfSeats - this.nameSeatNumber.size();
    }

    @Override
    public void addAllLuggage(List<Luggage> luggage) {
        for (Luggage luggage1: luggage){
            if (luggage1.isHold()){
                throw new RuntimeException("In private Plane You can not keep hold luggage");
            }
        }
        super.addAllLuggage(luggage);
    }
}
