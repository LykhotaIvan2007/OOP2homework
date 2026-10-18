package com.nhlstenden.vegetablegarden.vegetable;

public class Kale extends Vegetable
{
    private static final double CM_PER_LUX = 0.0057;
    private static final double CM_PER_MILIMETER = 0.032;
    private static final int RIPE_LENGTH = 16;
    private static final Color DEFAULT_COLOUR = Color.YELLOW;

    private static final int MM_TO_NOT_GROWS = 40;
    private static final int AMOUNT_OF_DAYS_TO_NOT_GROWS = 6;

    public Kale()
    {
        super(CM_PER_LUX, CM_PER_MILIMETER, RIPE_LENGTH, DEFAULT_COLOUR);
        // I think that when new Vegetable created it is like seed so it has size 0 and status growing
        super.setSizeInCm(0);
        super.setStatus(Status.GROWING);
    }

    @Override
    public void grow(int lux, int mm, int amountOfDays)
    {
        if (lux < 0)
        {
            throw new IllegalArgumentException("lux can not be less than 0");
        }
        if (mm < 0)
        {
            throw new IllegalArgumentException("mm can not be less than 0");
        }
        if (amountOfDays < 0)
        {
            throw new IllegalArgumentException("amountOfDays can not be less than 0");
        }
        // here I used the same logic as in Asparagus
        if (!(mm > MM_TO_NOT_GROWS && amountOfDays <= AMOUNT_OF_DAYS_TO_NOT_GROWS))
        {
            super.setSizeInCm((super.getCmPerMilimeter() * mm) + (super.getCmPerLux() * lux));
        }
        if (super.getCmPerLux() >= super.getRipeLength())
        {
            super.setStatus(Status.READY_TO_HARVEST);
        }
    }

    @Override
    public boolean isMarketable() {
        return false;
    }

    @Override
    public double getPrice() {
        return 0;
    }
}
