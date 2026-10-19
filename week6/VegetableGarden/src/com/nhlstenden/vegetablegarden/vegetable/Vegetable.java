package com.nhlstenden.vegetablegarden.vegetable;

public abstract class Vegetable
{
    private double sizeInCm;
    private double cmPerLux;
    private double cmPerMilimeter;
    private int ripeLength;
    private Color color;
    private Status status;

    public Vegetable(double cmPerLux, double cmPerMilimeter, int ripeLength, Color color)
    {
        this.setCmPerLux(cmPerLux);
        this.setCmPerMilimeter(cmPerMilimeter);
        this.setRipeLength(ripeLength);
        this.setColor(color);
    }

    public double getSizeInCm()
    {
        return sizeInCm;
    }

    public void setSizeInCm(double sizeInCm)
    {
        if (sizeInCm < 0)
        {
            throw new IllegalArgumentException("size can not be less than 0");
        }
        this.sizeInCm = sizeInCm;
    }

    public double getCmPerLux()
    {
        return cmPerLux;
    }

    public void setCmPerLux(double cmPerLux)
    {
        if (cmPerLux < 0)
        {
            throw new IllegalArgumentException("cmPerLux can not be less than 0");
        }
        this.cmPerLux = cmPerLux;
    }

    public double getCmPerMilimeter()
    {
        return cmPerMilimeter;
    }

    public void setCmPerMilimeter(double cmPerMilimeter)
    {
        if (cmPerMilimeter < 0)
        {
            throw new IllegalArgumentException("cmPerMilimeter can not be less than 0");
        }
        this.cmPerMilimeter = cmPerMilimeter;
    }

    public int getRipeLength()
    {
        return ripeLength;
    }

    public void setRipeLength(int ripeLength)
    {
        if (ripeLength <= 0)
        {
            throw new IllegalArgumentException("ripeLength can not be less or equals to 0");
        }
        this.ripeLength = ripeLength;
    }

    public Color getColor()
    {
        return color;
    }

    public void setColor(Color color)
    {
        if (color == null)
        {
            throw new IllegalArgumentException("color can not be null");
        }
        this.color = color;
    }

    public Status getStatus()
    {
        return status;
    }

    public void setStatus(Status status)
    {
        if (status == null)
        {
            throw new IllegalArgumentException("status can not be null");
        }
        this.status = status;
    }

    public abstract double getPrice();

    public abstract boolean isMarketable();

    public abstract void grow(int lux, int mm, int amountOfDays);
}
