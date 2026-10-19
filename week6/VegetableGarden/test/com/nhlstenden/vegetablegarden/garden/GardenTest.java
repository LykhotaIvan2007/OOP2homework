package com.nhlstenden.vegetablegarden.garden;

import com.nhlstenden.vegetablegarden.exceptions.TooManyVegetablesException;
import com.nhlstenden.vegetablegarden.vegetable.Kale;
import com.nhlstenden.vegetablegarden.vegetable.Pepper;
import com.nhlstenden.vegetablegarden.vegetable.Vegetable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GardenTest {
    private Garden garden;

    @BeforeEach
    void setUp()
    {
        garden = new Garden();
        double size = 0;
        for (int i = 0; i < 27 ; i++)
        {
            Vegetable vegetable = new Pepper();
            vegetable.setSizeInCm(size);
            size ++;
            garden.addVegetable(vegetable);
        }
    }

    @Test
    void addVegetable_PutMoreVegetableThanCanExists_ThrowExceptions()
    {
        assertThrows(TooManyVegetablesException.class, ()-> {
            garden.addVegetable(new Kale());
        });
    }
}