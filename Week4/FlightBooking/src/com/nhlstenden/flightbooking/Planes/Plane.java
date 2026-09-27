package com.nhlstenden.flightbooking.Planes;

import com.nhlstenden.flightbooking.Luggages.Luggage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Plane {
    private String code;
    private double currentFuelLevel;
    private List<Luggage> luggage;


    public Plane(String code, double currentFuelLevel) {
        this.code = code;
        this.currentFuelLevel = currentFuelLevel;
        this.luggage = new ArrayList<>();
    }

    public Plane() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getCurrentFuelLevel() {
        return currentFuelLevel;
    }

    public void setCurrentFuelLevel(double currentFuelLevel) {
        this.currentFuelLevel = currentFuelLevel;
    }

    public List<Luggage> getLuggage() {
        return luggage;
    }

    public void setLuggage(List<Luggage> luggage) {
        this.luggage = luggage;
    }

    public void addLuggage(Luggage luggage){
        this.luggage.add(luggage);
    }

    public void addAllLuggage(List<Luggage> luggage){
        this.luggage.addAll(luggage);
    }

    public double getWeightOfLuggage(){
        double weight = 0;
        for (Luggage luggage1: this.luggage){
            weight += luggage1.getWeightInKG();
        }

        return weight;
    }

    public abstract double getConsumeFuelAmount(double distanceOfFlight);
    public abstract void reserveSeat(String name);
    public abstract int getNumberOfEmptySeats();
}
