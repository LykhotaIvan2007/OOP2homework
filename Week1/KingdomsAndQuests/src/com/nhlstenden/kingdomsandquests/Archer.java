package com.nhlstenden.kingdomsandquests;

public class Archer extends Character
{
    public Archer(double heals, double damageValue, double defenceValue)
    {
        super(heals, damageValue, defenceValue);
    }

    @Override
    public void useSpecialAbility()
    {
        this.attack(2);
    }
}
