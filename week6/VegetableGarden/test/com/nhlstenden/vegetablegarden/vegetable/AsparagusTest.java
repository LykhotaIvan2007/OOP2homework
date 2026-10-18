package com.nhlstenden.vegetablegarden.vegetable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AsparagusTest {
    private Vegetable aspargus;

    @BeforeEach
    void setUp()
    {
        aspargus = new Asparagus();
    }

    @Test
    void grow_luxLessThan0_throwsExceptions()
    {
        assertThrows(IllegalArgumentException.class, ()-> {
            aspargus.grow(-1,1,1 );
        });
    }

    @Test
    void grow_MmLessThan0_throwsExceptions()
    {
        assertThrows(IllegalArgumentException.class, ()-> {
            aspargus.grow(1,-1,1 );
        });
    }

    @Test
    void grow_AmountOfDaysLessThan0_throwsExceptions()
    {
        assertThrows(IllegalArgumentException.class, ()-> {
            aspargus.grow(-1,1,1 );
        });
    }

    @Test
    void grow_mmLessThan14_StatusDestroyed()
    {
        aspargus.grow(1,1,10);
        assertEquals(Status.DESTROYED, aspargus.getStatus());
    }

    @Test
    void grow_lux4000000mm1000000day10_sizeWillChangeTo5008()
    {
        aspargus.grow(4000000,1000000,10);
        assertEquals(5008, aspargus.getSizeInCm());
    }

    @Test
    void grow_lux4000000mm1000000day10_statusReadyToHarvest()
    {
        aspargus.grow(4000000,1000000,10);
        assertEquals(Status.READY_TO_HARVEST, aspargus.getStatus());
    }
}