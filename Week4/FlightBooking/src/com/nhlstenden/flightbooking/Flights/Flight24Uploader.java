package com.nhlstenden.flightbooking.Flights;

import java.util.ArrayList;
import java.util.List;

public class Flight24Uploader {  // Actually here I don't understand which data I need to store, so I assume that here needs to store this data and I also do not see reasons to create class Flight24
    private List<String> flightsData;
    private List<String> planesData;

    public Flight24Uploader(List<String> flightsData, List<String> planesData) {
        this.flightsData = new ArrayList<>();
        this.planesData = new ArrayList<>();
    }

    public void uploadFlightData(String data){
        this.flightsData.add(data);
    }

    public void uploadPlaneData(String data){
        this.planesData.add(data);
    }
}
