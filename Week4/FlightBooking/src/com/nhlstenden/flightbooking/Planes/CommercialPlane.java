package com.nhlstenden.flightbooking.Planes;

import com.nhlstenden.flightbooking.Luggages.Luggage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommercialPlane extends Plane {
    private static final double ECONOMY_SEATS_MULTIPLICATION_NUMBER = 1.75;
    private static final double BUSINESS_SEATS_MULTIPLICATION_NUMBER = 1.98;
    private static final double ECONOMY_SEATS_TAKEN_MULTIPLICATION_NUMBER = 2.02;
    private static final double BUSINESS_SEATS_TAKEN_MULTIPLICATION_NUMBER = 2.87;
    private static final double WEIGHTS_OF_LUGGAGE_MULTIPLICATION_NUMBER = 0.3;
    private int numberOfEconomySeats;
    private int numberOfBusinessSeats;
    private Map<String, Integer> nameSeatNumberEconomy;
    private Map<String, Integer> nameSeatNumberBusiness;

    public CommercialPlane(String code, double currentFuelLevel, int numberOfEconomySeats, int numberOfBusinessSeats) {
        super(code, currentFuelLevel);
        this.nameSeatNumberEconomy = new HashMap<>();
        this.nameSeatNumberBusiness = new HashMap<>();
        this.numberOfEconomySeats = numberOfEconomySeats;
        this.numberOfBusinessSeats = numberOfBusinessSeats;
    }

    @Override
    public double getConsumeFuelAmount(double distanceOfFlight) {
        return (this.numberOfEconomySeats * ECONOMY_SEATS_MULTIPLICATION_NUMBER) +
                (this.numberOfBusinessSeats * BUSINESS_SEATS_MULTIPLICATION_NUMBER) *
                 distanceOfFlight +
                (this.nameSeatNumberEconomy.size() * ECONOMY_SEATS_TAKEN_MULTIPLICATION_NUMBER) +
                (this.nameSeatNumberBusiness.size() * BUSINESS_SEATS_TAKEN_MULTIPLICATION_NUMBER) +
                (super.getWeightOfLuggage() * WEIGHTS_OF_LUGGAGE_MULTIPLICATION_NUMBER);
    }

    @Override
    public void reserveSeat(String name) {
        if (name == null || name.isBlank()){
            throw new IllegalArgumentException("name can not be null or empty");
        }
        if (this.numberOfEconomySeats < this.nameSeatNumberEconomy.size() + 1 && this.numberOfBusinessSeats < this.nameSeatNumberBusiness.size() +1){
            throw new RuntimeException("all seats are taken");
        }
        if (this.numberOfEconomySeats > this.nameSeatNumberEconomy.size() + 1){
            this.nameSeatNumberEconomy.put(name, this.nameSeatNumberEconomy.size() + 1);
        }else {
            this.nameSeatNumberBusiness.put(name, this.nameSeatNumberBusiness.size() + 1);
        }
    }

    @Override
    public int getNumberOfEmptySeats() {
        return this.numberOfEconomySeats - this.nameSeatNumberEconomy.size() + this.numberOfBusinessSeats - this.nameSeatNumberBusiness.size();
    }

    public void reserveEconomySeat(String name){
        if (name == null || name.isBlank()){
            throw new IllegalArgumentException("name can not be null or empty");
        }
        if (this.numberOfEconomySeats + 1 > this.nameSeatNumberEconomy.size()){
            throw new RuntimeException("all economy seats are taken");
        }
        this.nameSeatNumberEconomy.put(name, this.nameSeatNumberEconomy.size() + 1);
    }

    public void reserveBusinessSeat(String name){
        if (name == null || name.isBlank()){
            throw new IllegalArgumentException("name can not be null or empty");
        }
        if (this.numberOfBusinessSeats + 1 > this.nameSeatNumberBusiness.size()){
            throw new RuntimeException("all business seats are taken");
        }
        this.nameSeatNumberBusiness.put(name, this.nameSeatNumberBusiness.size() + 1);
    }
}
