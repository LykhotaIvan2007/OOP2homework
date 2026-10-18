package com.nhlstenden.vegetablegarden.garden;

import com.nhlstenden.vegetablegarden.exceptions.TooManyVegetablesException;
import com.nhlstenden.vegetablegarden.vegetable.Status;
import com.nhlstenden.vegetablegarden.vegetable.Vegetable;

import java.util.HashSet;

public class Garden
{
    private HashSet<Vegetable> vegetables;

    public Garden()
    {
        this.vegetables = new HashSet<>();
    }

    public HashSet<Vegetable> getVegetables() {
        return vegetables;
    }

    public void addVegetable(Vegetable vegetable)
    {
        if (this.vegetables.size() >= 27)
        {
            throw new TooManyVegetablesException();
        }
        if (vegetable == null)
        {
            throw new IllegalArgumentException("vegetable can not be null");
        }
        this.vegetables.add(vegetable);
    }

    public HashSet<Vegetable> getReadyForHarvestVegetables()
    {
        HashSet<Vegetable> readyForHarvest = new HashSet<>();
        for (Vegetable vegetable: this.vegetables)
        {
            if (vegetable.getStatus() == Status.READY_TO_HARVEST) {
                readyForHarvest.add(vegetable);
            }
        }
        this.vegetables.removeAll(readyForHarvest);

        return readyForHarvest;
    }
}
