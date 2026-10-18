package com.nhlstenden.vegetablegarden.vegetable;

public class Asparagus extends Vegetable
{
    private static final double CM_PER_LUX = 0.000027;
    private static final double CM_PER_MILIMETER = 0.0049;
    private static final int RIPE_LENGTH = 20;
    private static final Color DEFAULT_COLOUR = Color.BLUE;

    private static final int AMOUNT_OF_DAYS_TO_DESTROYED = 10;
    private static final int MM_TO_DESTROYED = 14;

    private static final int MAX_SIZE = 29;

    private static final double NUMBER_TO_MULTIPLY_FOR_PRICE = 0.12;

    public Asparagus()
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
        // actually I don't know how correctly measure how much water receive Asparagus because it is not written (in class diagram) how much water it receives each day (in class diagram method receives total amount of mm) so if in this method will receive 20 days and 28 mm it will be satisfied, but it is impossible to check when the plant receives water because it can receive all water in first 10 days so I think that in this class check can be normally validated only for 10 days or less
        if (amountOfDays >= AMOUNT_OF_DAYS_TO_DESTROYED && mm < MM_TO_DESTROYED)
        {
            super.setStatus(Status.DESTROYED);
        }
        else
        {
            super.setSizeInCm((super.getCmPerMilimeter() * mm) + (super.getCmPerLux() * lux));
        }
        if (super.getSizeInCm() >= super.getRipeLength())
        {
            super.setStatus(Status.READY_TO_HARVEST);
        }
    }

    @Override
    public boolean isMarketable() {
        return super.getSizeInCm() <= MAX_SIZE && super.getStatus() == Status.READY_TO_HARVEST;
    }

    @Override
    public double getPrice() {
        return isMarketable() ? super.getSizeInCm() * NUMBER_TO_MULTIPLY_FOR_PRICE : 0;
    }
}
