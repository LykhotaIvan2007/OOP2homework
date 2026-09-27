package com.nhlstenden.flightbooking.Luggages;

public class Luggage {
    private double weightInKG;
    private boolean isHold;

    public Luggage(double weightInKG, boolean isHold) {
        this.weightInKG = weightInKG;
        this.isHold = isHold;
    }

    public double getWeightInKG() {
        return weightInKG;
    }

    public void setWeightInKG(double weightInKG) {
        this.weightInKG = weightInKG;
    }

    public boolean isHold() {
        return isHold;
    }

    public void setHold(boolean hold) {
        isHold = hold;
    }
}
