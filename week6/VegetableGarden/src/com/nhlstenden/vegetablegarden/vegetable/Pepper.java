package com.nhlstenden.vegetablegarden.vegetable;

public class Pepper extends Vegetable
{
    private static final double CM_PER_LUX = 0.000044;
    private static final double CM_PER_MILIMETER = 0.0013;
    private static final int RIPE_LENGTH = 7;
    private static final Color DEFAULT_COLOUR = Color.PINK;

    private static final int DAYS_TO_DESTROYED = 4;
    private static final int MM_TO_DESTROYED = 31;

    private static final int DAYS_TO_NOT_GROW = 10;
    private static final int MM_TO_NOT_GROW = 25;

    private static final int MIN_SIZE = 15;
    private static final int MAX_SIZE = 21;

    private static final double NUMBER_TO_MULTIPLY_FOR_PRICE = 0.15;

    public Pepper()
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
        if (amountOfDays > DAYS_TO_DESTROYED && mm > MM_TO_DESTROYED)
        {
            super.setStatus(Status.DESTROYED);
        }
        if (!(mm < MM_TO_NOT_GROW && amountOfDays >= DAYS_TO_NOT_GROW))
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
        return super.getSizeInCm() >= MIN_SIZE && super.getSizeInCm() <= MAX_SIZE &&super.getStatus() == Status.READY_TO_HARVEST;
    }

    @Override
    public double getPrice() {
        return isMarketable() ? super.getSizeInCm() * NUMBER_TO_MULTIPLY_FOR_PRICE : 0;
    }
}
