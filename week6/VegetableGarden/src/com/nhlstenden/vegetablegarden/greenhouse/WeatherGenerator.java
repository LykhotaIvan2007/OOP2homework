package com.nhlstenden.vegetablegarden.greenhouse;

import java.time.Period;

public class WeatherGenerator
{
    private static final int MAX_LUX = 101592;
    private static final int MIN_LUX = 1000;

    private static final int MAX_MM = 48;
    private static final int MIN_MM = 0;

    public static int generateRandomLux()
    {
        return (int) (Math.random() * (MAX_LUX - MIN_LUX +1)) + MIN_LUX;
    }

    public static int generateRandomMm()
    {
        return (int) (Math.random() * (MAX_MM - MIN_MM + 1)) + MIN_MM;
    }
}
