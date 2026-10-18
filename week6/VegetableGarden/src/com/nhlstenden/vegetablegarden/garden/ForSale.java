package com.nhlstenden.vegetablegarden.garden;

import com.nhlstenden.vegetablegarden.vegetable.Vegetable;

import java.util.HashSet;

public class ForSale
{
    private HashSet<Vegetable> marketableVegetables;

    public ForSale()
    {
        this.marketableVegetables = new HashSet<>();
    }

    public void addMarketableVegetables(HashSet<Vegetable> vegetables)
    {
        for (Vegetable vegetable: vegetables)
        {
            if (vegetable.isMarketable())
            {
                this.marketableVegetables.add(vegetable);
            }
        }
    }

    public double retrieveAllProfit()
    {
        double profit = 0;
        for (Vegetable vegetable: this.marketableVegetables)
        {
            profit += vegetable.getPrice();
        }

        return profit;
    }
}
