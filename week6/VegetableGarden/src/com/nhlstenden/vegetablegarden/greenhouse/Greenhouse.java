package com.nhlstenden.vegetablegarden.greenhouse;

import com.nhlstenden.vegetablegarden.garden.Garden;
import com.nhlstenden.vegetablegarden.vegetable.Vegetable;

public class Greenhouse extends Garden
{
    public void runWeather()
    {
        int lux = WeatherGenerator.generateRandomLux();
        int mm = WeatherGenerator.generateRandomMm();
        for (Vegetable vegetable: super.getVegetables())
        {
            vegetable.grow(lux, mm, 1);
        }
    }
}
